#!/bin/bash
version=2
if [ $version != 0 ]
then
    docker rmi -f shiki92/platform_node:latest shiki92/platform_node:$version
fi
let "version++"
docker build -f dockerfile -t shiki92/platform_node:$version .
docker tag shiki92/platform_node:$version shiki92/platform_node:latest