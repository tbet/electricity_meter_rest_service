# electricity_meter_rest_service
SpringBoot REST Service to provide SML electricity meter reading via usb optical head connection

e.g. http://localhost:8080/energy
>*{
>*	"appliedMethod": "I-INFO",
>*	"timestamp": "2020-10-03T15:19:17Z",
>*	"v_1_8_0": 2424.3247,
>*	"v_1_8_1": 2424.3247,
>*	"v_1_8_2": 0.0,
>*	"v_2_8_0": null,
>*	"power": 2352.0,
>*	"serverID": "09 01 ... 3E 5D",
>*	"secindex": 17...034
>*}

## Rest Service for use with OpenHAB
Rest Service can run on other server than OpenHAB server

## Configuration for OpenHAB to visualize electricity meter data
openhab config files to visualize electricity meter included in project

## Used "Optokopf"
IR Schreib/Lesekopf USB (Optokopf) https://shop.weidmann-elektronik.de/index.php?page=product&info=24

## Prerequisites
1. Install OpenHab on Linux Server A e.g. via docker-compose.yml -> https://github.com/openhab/openhab-docker
>* Install HTTP Binding (http://ServerA:8080/paperui/index.html#/extensions?tab=binding)
>* Install RRD4j Persistence (http://ServerA:8080/paperui/index.html#/extensions?tab=persistence)
>* Config files will be placed below /var/lib/docker/volumes/openhab_openhab_config
>* Summery page will be availible on http://ServerA:8080/basicui/app
2. Pepare Linux Server B to serve the REST Service
>* sudo apt-get install librxtx-java
>* sudo adduser <yourUserName> dialout
>* sudo adduser <yourUserName> tty
3. Build REST Service (tested with java11)
>* Activate separately both pom.xml artifacts (mvn validate) to transfer both jar files to local maven repo 
>* maven based SpringBoot Service (mvn clean package)
4. Transfer build jar file to Server B and start REST Service
>* Start REST Service via "java -jar energy_only-1.0-SNAPSHOT.jar" 
>* Crontab restart scenario "@reboot /usr/bin/java -jar /home/USERNAME/electricity_meter_rest_service-1.0-SNAPSHOT.jar > /dev/null 2>&1"

## Java
Following parameters are relevant
>* -Djava.library.path=/usr/lib/jni
>* -Dgnu.io.rxtx.SerialPorts=/dev/ttyUSB0

## Related links
1. General: https://www.heise.de/select/ct/2018/8/1523221532486836
2. Library jSML: https://www.openmuc.org/sml/download/
>* Behavior changed in version 1.1.x so i used the older 1.0.1 version
3. Library jrxtx: https://github.com/openmuc/jrxtx
>* Compiled jar with native gnu.io lib included
4. Other Java Project where both components is on one server: https://github.com/jblu48317/SMLToJSON

