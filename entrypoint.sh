#!/bin/bash
java -jar -XshowSettings:vm -Xms1024m -Xmx1536m -Djava.security.egd=file:/dev/./urandom -ea app/demo.jar
exit 0