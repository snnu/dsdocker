#!/bin/bash
version=0
if [ $version != 0 ]
then
    docker rmi -f shiki92/foundation_jar:latest shiki92/foundation_jar:$version
fi
let "version++"
docker build -f dockerfile -t shiki92/foundation_jar:$version .
docker tag shiki92/foundation_jar:$version shiki92/foundation_jar:latest