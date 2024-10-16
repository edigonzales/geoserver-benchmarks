# geoserver-benchmarks

```
wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.95/bin/apache-tomcat-9.0.95.tar.gz
wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.96/bin/apache-tomcat-9.0.96.tar.gz

```
```
wget http://sourceforge.net/projects/geoserver/files/GeoServer/2.26.0/geoserver-2.26.0-war.zip 
```

```
wget https://files.geo.so.ch/ch.swisstopo.swissimage_2021.rgb/aktuell/ch.swisstopo.swissimage_2021.rgb.tif
```

```
wget https://dlcdn.apache.org//jmeter/binaries/apache-jmeter-5.6.3.zip
```

curl -s "https://get.sdkman.io" | bash

```
export CATALINA_OPTS="--add-exports=java.desktop/sun.awt.image=ALL-UNNAMED \
--add-opens=java.base/java.lang=ALL-UNNAMED \
--add-opens=java.base/java.util=ALL-UNNAMED \
--add-opens=java.base/java.lang.reflect=ALL-UNNAMED \
--add-opens=java.base/java.text=ALL-UNNAMED \
--add-opens=java.desktop/java.awt.font=ALL-UNNAMED \
--add-opens=java.desktop/sun.awt.image=ALL-UNNAMED \
--add-opens=java.naming/com.sun.jndi.ldap=ALL-UNNAMED \
--add-opens=java.desktop/sun.java2d.pipe=ALL-UNNAMED \
-server -Djava.awt.headless=true \
-Dfile.encoding=UTF-8 \
-Djavax.servlet.request.encoding=UTF-8 \
-Djavax.servlet.response.encoding=UTF-8 \
-D-XX:SoftRefLRUPolicyMSPerMB=36000 \
-Xms4096m -Xmx4096m \
-Xbootclasspath/a:$CATALINA_HOME/lib/marlin.jar \
-Dsun.java2d.renderer=sun.java2d.marlin.DMarlinRenderingEngine \
-Dorg.geotools.coverage.jaiext.enabled=true \
-Dorg.apache.tomcat.util.digester.PROPERTY_SOURCE=org.apache.tomcat.util.digester.EnvironmentPropertySource"
```

```
export CATALINA_OPTS="--add-exports=java.desktop/sun.awt.image=ALL-UNNAMED \
--add-opens=java.base/java.lang=ALL-UNNAMED \
--add-opens=java.base/java.util=ALL-UNNAMED \
--add-opens=java.base/java.lang.reflect=ALL-UNNAMED \
--add-opens=java.base/java.text=ALL-UNNAMED \
--add-opens=java.desktop/java.awt.font=ALL-UNNAMED \
--add-opens=java.desktop/sun.awt.image=ALL-UNNAMED \
--add-opens=java.naming/com.sun.jndi.ldap=ALL-UNNAMED \
--add-opens=java.desktop/sun.java2d.pipe=ALL-UNNAMED \
-server -Djava.awt.headless=true \
-Dfile.encoding=UTF-8 \
-Djavax.servlet.request.encoding=UTF-8 \
-Djavax.servlet.response.encoding=UTF-8 \
-D-XX:SoftRefLRUPolicyMSPerMB=36000 \
-D-XX:+UseParallelGC \
-Xms4096m -Xmx4096m \
-Xbootclasspath/a:$CATALINA_HOME/lib/marlin.jar \
-Dsun.java2d.renderer=sun.java2d.marlin.DMarlinRenderingEngine \
-Dorg.geotools.coverage.jaiext.enabled=true \
-Dorg.apache.tomcat.util.digester.PROPERTY_SOURCE=org.apache.tomcat.util.digester.EnvironmentPropertySource"
```

```
export CATALINA_OPTS="--add-exports=java.desktop/sun.awt.image=ALL-UNNAMED \
--add-opens=java.base/java.lang=ALL-UNNAMED \
--add-opens=java.base/java.util=ALL-UNNAMED \
--add-opens=java.base/java.lang.reflect=ALL-UNNAMED \
--add-opens=java.base/java.text=ALL-UNNAMED \
--add-opens=java.desktop/java.awt.font=ALL-UNNAMED \
--add-opens=java.desktop/sun.awt.image=ALL-UNNAMED \
--add-opens=java.naming/com.sun.jndi.ldap=ALL-UNNAMED \
--add-opens=java.desktop/sun.java2d.pipe=ALL-UNNAMED \
-server -Djava.awt.headless=true \
-Dfile.encoding=UTF-8 \
-Djavax.servlet.request.encoding=UTF-8 \
-Djavax.servlet.response.encoding=UTF-8 \
-D-XX:SoftRefLRUPolicyMSPerMB=36000 \
-D-XX:+UseStringDeduplicationJVM \
-Xms4096m -Xmx4096m \
-Xbootclasspath/a:$CATALINA_HOME/lib/marlin.jar \
-Dsun.java2d.renderer=sun.java2d.marlin.DMarlinRenderingEngine \
-Dorg.geotools.coverage.jaiext.enabled=true \
-Dorg.apache.tomcat.util.digester.PROPERTY_SOURCE=org.apache.tomcat.util.digester.EnvironmentPropertySource"
```


```
/root/geoserver-benchmarks/scripts/2056.csv
```

```
docker run --rm --name pubdb -p 54322:5432 -v pgdata-geoserver-benchmark:/var/lib/postgresql/data:delegated -e POSTGRES_PASSWORD=secret -e POSTGRES_DB=pub sogis/postgis:16-3.4
```

```
docker run -i --rm --name gretl --entrypoint="/bin/sh" -u $UID -v $PWD:/home/gradle/project sogis/gretl:latest -c 'gretl tasks --all'
```

```
sdk i groovy 4.0.15
sdk u groovy 4.0.15
sdk u java 17.0.12-graal
```

Uber-Jar von Github-Repo.
```
java -jar ../../../Downloads/geoscript-groovy-app-1.22.0.jar script wms_requests.groovy 
```

```
java -jar ../../../Downloads/geoscript-groovy-app-1.22.0.jar script wms_requests.groovy -count 10000 -region 2590000 1210000 2650000 1270000 -maxres 50 -minres 0.01 -maxsize 2560 1440 -minsize 1920 1080 -filter_intersects gemeindegrenze.shp

java -jar ../../../Downloads/geoscript-groovy-app-1.22.0.jar script wms_requests.groovy -count 50000 -region 2590000 1210000 2650000 1270000 -maxres 100 -minres 0.01 -maxsize 3840 2160 -minsize 1920 1080 -filter_intersects gemeindegrenze.shp
```

```
http://localhost:8080/geoserver/topp/wms?SERVICE=WMS&VERSION=1.1.1&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&STYLES&LAYERS=topp%3Anutzungsplanung_grundnutzung&SRS=EPSG%3A2056&WIDTH=768&HEIGHT=700&BBOX=2614044.9674958545%2C1229525.750914785%2C2628704.44799237%2C1242887.2565756715
```

```
magick montage flotHitsPerSecond.png flotHitsPerSecond_1.png flotHitsPerSecond_2.png flotHitsPerSecond_3.png -tile 2x2 -geometry +0+0 graal-17-g1gc.png
```

```
/Users/stefan/apps/apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-v1.jtl -e -o graal-17-g1gc-v1

../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-controlflow-v1.jtl -e -o graal-17-g1gc-controlflow-v1 (ows.wms.getmap=12)


../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-v1.jtl -e -o graal-17-g1gc-v1
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-17-g1gc-v1.jtl -e -o temurin-17-g1gc-v1
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-v2.jtl -e -o graal-17-g1gc-v2
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-17-g1gc-v2.jtl -e -o temurin-17-g1gc-v2
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-v3.jtl -e -o graal-17-g1gc-v3
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-17-g1gc-v3.jtl -e -o temurin-17-g1gc-v3
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-v4.jtl -e -o graal-17-g1gc-v4
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-17-g1gc-v4.jtl -e -o temurin-17-g1gc-v4

../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-11-g1gc-v1.jtl -e -o temurin-11-g1gc-v1
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-11-g1gc-v2.jtl -e -o temurin-11-g1gc-v2
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-11-g1gc-v3.jtl -e -o temurin-11-g1gc-v3
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-11-g1gc-v4.jtl -e -o temurin-11-g1gc-v4

../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-parallelgc-v1.jtl -e -o graal-17-parallelgc-v1
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-parallelgc-v2.jtl -e -o graal-17-parallelgc-v2
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-parallelgc-v3.jtl -e -o graal-17-parallelgc-v3
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-parallelgc-v4.jtl -e -o graal-17-parallelgc-v4

../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-21-g1gc-v1.jtl -e -o graal-21-g1gc-v1
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-21-g1gc-v2.jtl -e -o graal-21-g1gc-v2
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-21-g1gc-v3.jtl -e -o graal-21-g1gc-v3
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-21-g1gc-v4.jtl -e -o graal-21-g1gc-v4
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-v5.jtl -e -o graal-17-g1gc-v5



../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-arm-v1.jtl -e -o graal-17-g1gc-arm-v1
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-17-g1gc-arm-v1.jtl -e -o temurin-17-g1gc-arm-v1
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-arm-v2.jtl -e -o graal-17-g1gc-arm-v2
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-17-g1gc-arm-v2.jtl -e -o temurin-17-g1gc-arm-v2
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-arm-v3.jtl -e -o graal-17-g1gc-arm-v3
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l temurin-17-g1gc-arm-v3.jtl -e -o temurin-17-g1gc-arm-v3

../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-21-g1gc-arm-v1.jtl -e -o graal-21-g1gc-arm-v1
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-21-g1gc-arm-v2.jtl -e -o graal-21-g1gc-arm-v2
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-21-g1gc-arm-v3.jtl -e -o graal-21-g1gc-arm-v3
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-arm-v4.jtl -e -o graal-17-g1gc-arm-v4


../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-stringdupl-arm-v1.jtl -e -o graal-17-g1gc-stringdupl-arm-v1
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx  -l graal-17-g1gc-stringdupl-arm-v2.jtl -e -o graal-17-g1gc-stringdupl-arm-v2
https://blog.gceasy.io/degradation-in-string-deduplication-performance-in-recent-java-versions/

```


```
apt-get update
apt-get install zip unzip
curl -s "https://get.sdkman.io" | bash
```

```
apt-get update
#apt-get install xubuntu-desktop
apt-get install xfce4-goodies xfce4


apt-get install software-properties-common
add-apt-repository ppa:x2go/stable
apt-get update
apt-get install x2goserver x2goserver-xsession
```


```
Caused by: org.gradle.api.UncheckedIOException: Failed to create parent directory '/home/gradle/project/.gradle' when creating directory '/home/gradle/project/.gradle/5.1.1/fileHashes'
	at org.gradle.util.GFileUtils.mkdirs(GFileUtils.java:327)
	at org.gradle.cache.internal.DefaultPersistentDirectoryStore.open(DefaultPersistentDirectoryStore.java:75)
	at org.gradle.cache.internal.DefaultPersistentDirectoryStore.open(DefaultPersistentDirectoryStore.java:42)
	at org.gradle.cache.internal.DefaultCacheFactory.doOpen(DefaultCacheFactory.java:94)
	at org.gradle.cache.internal.DefaultCacheFactory.open(DefaultCacheFactory.java:68)
	at org.gradle.cache.internal.DefaultCacheRepository$PersistentCacheBuilder.open(DefaultCacheRepository.java:118)
	at org.gradle.api.internal.changedetection.state.CrossBuildFileHashCache.<init>(CrossBuildFileHashCache.java:45)
	at org.gradle.internal.service.scopes.BuildSessionScopeServices.createCrossBuildFileHashCache(BuildSessionScopeServices.java:159)
	at org.gradle.internal.reflect.JavaMethod.invoke(JavaMethod.java:73)
	at org.gradle.internal.service.ReflectionBasedServiceMethod.invoke(ReflectionBasedServiceMethod.java:35)
	at org.gradle.internal.service.DefaultServiceRegistry$FactoryMethodService.invokeMethod(DefaultServiceRegistry.java:821)
	... 92 more
```

-> `chmod -R 777 .`


```
../apache-jmeter-5.6.3/bin/jmeter -n -t benchmark.jmx -l graal-17-g1gc.jtl -e -o graal-17-g1gc



```