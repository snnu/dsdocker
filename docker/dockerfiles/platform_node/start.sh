#!/bin/bash
bash /fisco/node/node/start_all.sh
bash /fisco/webase/start.sh
while true
do
    bash /fisco/webase/status.sh
    sleep 5
done
