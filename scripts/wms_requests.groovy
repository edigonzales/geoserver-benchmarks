#!/usr/bin/env groovy

import geoscript.geom.Geometry
import geoscript.geom.Polygon
import geoscript.geom.MultiPolygon
import geoscript.geom.GeometryCollection
import geoscript.layer.Shapefile
import geoscript.proj.Projection
//import geoscript.proj.Transform
import geoscript.geom.Bounds
import java.util.Random

// Usage function to display help message
def Usage() {
    println 'Usage: wms_request.groovy [-count n] [-region minx miny maxx maxy]'
    println '                    [-minres minres] [-maxres maxres]'
    println '                    [-maxsize width height] [-minsize width height]'
    println '                    [-srs <epsg_code>] [-srs2 <epsg_code>]'
    println '                    [-filter_within <filename>]'
    println '                    [-filter_intersects <filename>]'
    System.exit(1)
}


// Default parameters
def region = null
def minres = null
def maxres = null
def count = 1000
def minsize = [128, 128]
def maxsize = [1024, 768]
def filter_within = null
def filter_intersects = null
def geometry_collection = null
def dataset = null
def srs_input = 2056
def srs_output = null
def coordinate_transformation = null
def output_file = null
def output_file2 = null

// Command line arguments parsing
def args = this.args
def i = 0
while (i < args.length) {
    def arg = args[i]
    
    switch(arg) {
        case '-region':
            if (i + 4 < args.length) {
                region = [args[i + 1].toFloat(), args[i + 2].toFloat(), args[i + 3].toFloat(), args[i + 4].toFloat()]
                i += 4
            } else {
                Usage()
            }
            break
        case '-minsize':
            if (i + 2 < args.length) {
                minsize = [args[i + 1].toInteger(), args[i + 2].toInteger()]
                i += 2
            } else {
                Usage()
            }
            break
        case '-maxsize':
            if (i + 2 < args.length) {
                maxsize = [args[i + 1].toInteger(), args[i + 2].toInteger()]
                i += 2
            } else {
                Usage()
            }
            break
        case '-minres':
            if (i + 1 < args.length) {
                minres = args[i + 1].toFloat()
                i += 1
            } else {
                Usage()
            }
            break
        case '-maxres':
            if (i + 1 < args.length) {
                maxres = args[i + 1].toFloat()
                i += 1
            } else {
                Usage()
            }
            break
        case '-count':
            if (i + 1 < args.length) {
                count = args[i + 1].toInteger()
                i += 1
            } else {
                Usage()
            }
            break
        case '-filter_within':
            if (i + 1 < args.length) {
                filter_within = args[i + 1]
                i += 1
            } else {
                Usage()
            }
            break
        case '-filter_intersects':
            if (i + 1 < args.length) {
                filter_intersects = args[i + 1]
                i += 1
            } else {
                Usage()
            }
            break
        case '-srs':
            if (i + 1 < args.length) {
                srs_input = args[i + 1].toInteger()
                i += 1
            } else {
                Usage()
            }
            break
        case '-srs2':
            if (i + 1 < args.length) {
                srs_output = args[i + 1].toInteger()
                i += 1
            } else {
                Usage()
            }
            break
        default:
            println "Unable to process: $arg"
            Usage()
            break
    }
    i += 1
}

// Check for required parameters
if (region == null) {
    println '-region is required.'
    Usage()
}
if (minres == null) {
    println '-minres is required.'
    Usage()
}
if (maxres == null) {
    println '-maxres is required.'
    Usage()
}

// Load geometry if filter options are used
if (filter_within || filter_intersects) {
    println filter_intersects
    try {
        if (filter_within != null) {
            dataset = new Shapefile(filter_within)
        } else {
            dataset = new Shapefile(filter_intersects)
        }

        //geometry_collection = new Geometry('GeometryCollection')
        List<MultiPolygon> polys = new ArrayList<>()
        dataset.features.each { 
            polys.add(it.geom)
        }

        geometry_collection = new GeometryCollection(polys)

/*
        geometry_collection = dataset.features.collect { it.geom }.inject(new Geometry('GeometryCollection')) { coll, geom ->
            coll.add(geom)
            coll
        }
*/
    } catch (Exception e) {
        println e
        println "Unable to open dataset: $filter_within"
        Usage()
    }
}

// Coordinate transformation
if (srs_output != null) {
    def sourceProj = new Projection("EPSG:$srs_input")
    def targetProj = new Projection("EPSG:$srs_output")
    //coordinate_transformation = new Transform(sourceProj, targetProj)
}

// Output files
output_file = new File("./${srs_input}.csv").newWriter()
if (srs_output != null) {
    output_file2 = new File("./${srs_output}.csv").newWriter()
}

// Random request generation
def random = new Random()
def first = true

while (count > 0) {
    def width = random.nextInt(maxsize[0] - minsize[0] + 1) + minsize[0]
    def height = random.nextInt(maxsize[1] - minsize[1] + 1) + minsize[1]
    
    def centerX = region[0] + random.nextDouble() * (region[2] - region[0])
    def centerY = region[1] + random.nextDouble() * (region[3] - region[1])
    
    def random_log = Math.log(minres) + random.nextDouble() * (Math.log(maxres) - Math.log(minres))
    def res = Math.exp(random_log)
    
    def bbox = [
        centerX - width * 0.5 * res,
        centerY - height * 0.5 * res,
        centerX + width * 0.5 * res,
        centerY + height * 0.5 * res
    ]
    
    if (bbox[0] >= region[0] && bbox[1] >= region[1] && bbox[2] <= region[2] && bbox[3] <= region[3]) {
        if (filter_within != null) {
            def polygon = Geometry.polygon(bbox)
            if (!geometry_collection.contains(polygon)) continue
        }

        if (filter_intersects != null) {
            def bounds = new Bounds(bbox[0], bbox[1], bbox[2], bbox[3])
            def polygon = bounds.getGeometry()
            if (!geometry_collection.intersects(polygon)) {
                continue
            }
        }

        if (srs_output != null) {
            def transformed = Projection.transform(new Bounds(bbox[0], bbox[1], bbox[2], bbox[3]))
            def delta_original = (bbox[2] - bbox[0]) / (bbox[3] - bbox[1])
            def delta_transformed = (transformed.maxX - transformed.minX) / (transformed.maxY - transformed.minY)
            def pixels = width * height
            def srs2_height = Math.floor(Math.sqrt(pixels / delta_transformed))
            def srs2_width = Math.floor(delta_transformed * srs2_height)
        }

        def layers = ["nutzungsplanung_grundnutzung", "ch.swisstopo.swissimage_2021.rgb"];
        int randomIndex = random.nextInt(layers.size());
        String randomLayer = layers[randomIndex];

        if (first) {
            output_file.write(width+";"+height+";"+bbox[0]+","+bbox[1]+","+bbox[2]+","+bbox[3]+";"+randomLayer+"\n")
            if (srs_output != null) {
                output_file2.write("$srs2_width;$srs2_height;${transformed.minX},${transformed.minY},${transformed.maxX},${transformed.maxY}\n")
            }
            first = false
        } else {
            output_file.write(width+";"+height+";"+bbox[0]+","+bbox[1]+","+bbox[2]+","+bbox[3]+";"+randomLayer+"\n")
            if (srs_output != null) {
                output_file2.write("$srs2_width;$srs2_height;${transformed.minX},${transformed.minY},${transformed.maxX},${transformed.maxY}\n")
            }
        }
        count--
    }
}

// Clean up
output_file.close()
if (output_file2 != null) output_file2.close()



println("Hallo Welt.")