#!/bin/bash
version=5
if [ $version != 0 ]
then
    docker rmi -f shiki92/hospital_node:latest shiki92/hospital_node:$version
fi
let "version++"
docker build -f dockerfile -t shiki92/hospital_node:$version .
docker tag shiki92/hospital_node:$version shiki92/hospital_node:latest