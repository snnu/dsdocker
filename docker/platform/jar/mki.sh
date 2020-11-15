#!/bin/bash
version=0
if [ $version != 0 ]
then
    docker rmi -f shiki92/platform_jar:latest shiki92/platform_jar:$version
fi
let "version++"
docker build -f dockerfile -t shiki92/platform_jar:$version .
docker tag shiki92/platform_jar:$version shiki92/platform_jar:latest