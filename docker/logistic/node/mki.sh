#!/bin/bash
version=1
if [ $version != 0 ]
then
    docker rmi -f shiki92/logistic_node:latest shiki92/logistic_node:$version
fi
let "version++"
docker build -f dockerfile -t shiki92/logistic_node:$version .
docker tag shiki92/logistic_node:$version shiki92/logistic_node:latest