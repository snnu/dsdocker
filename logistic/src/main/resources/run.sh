#!/bin/sh

echo "********************************************************"
echo "Waiting for the node to start on port 20200"
echo "********************************************************"
while ! `nc -z 172.100.0.3 20200`; do sleep 3; done
echo "******* platform_jar: node has started"

echo "********************************************************"
echo "Waiting for the paltform to start"
echo "********************************************************"
while ! `nc -z 172.100.0.9 8080`; do sleep 3; done
echo "******* logistic_jar: platform_jar has started"

java $JVM_OPS -Djava.security.egd=file:/dev/./urandom -jar app.jar
