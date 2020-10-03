# electricity_meter_rest_service
SpringBoot REST Service to provide SML electricity meter reading via usb optical head connection

e.g. http://localhost:8080/energy
{
	"appliedMethod": "I-INFO",
	"timestamp": "2020-10-03T15:19:17Z",
	"v_1_8_0": 2424.3247,
	"v_1_8_1": 2424.3247,
	"v_1_8_2": 0.0,
	"v_2_8_0": null,
	"power": 2352.0,
	"serverID": "09 01 49 53 4B 00 04 4F 3E 5D",
	"secindex": 17814034
}

## Rest Service for use with OpenHAB
Rest Service can run on other server than OpenHAB server

## Configuration for OpenHAB to visualize electricity meter data
openhab config files to visualize electricity meter included in project

## Prerequisites
* Install OpenHab on Linux Server A e.g. via docker-compose.yml -> https://github.com/openhab/openhab-docker
** Config files will be below /var/lib/docker/volumes/openhab_openhab_config
* Pepare Linux Server B
** sudo apt-get install librxtx-java
** sudo adduser <yourUserName> dialout
** sudo adduser <yourUserName> tty

## Java
Following parameters are relevant
-Djava.library.path=/usr/lib/jni
-Dgnu.io.rxtx.SerialPorts=/dev/ttyUSB0


## Related links
https://www.heise.de/select/ct/2018/8/1523221532486836


