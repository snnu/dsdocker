#!/bin/sh

service nginx start
ps -ef | grep nginx
{
bash /app/webase/nodeManager/start.sh
sleep 2;
bash /app/webase/nodeManager/status.sh
}&

echo "********************************************************"
echo "Waiting for the node to start on port 20200"
echo "********************************************************"
while ! `nc -z 172.100.0.5 20200`; do sleep 3; done
echo "******* platform_jar: node has started"

java $JVM_OPS -Djava.security.egd=file:/dev/./urandom -jar app.jar







