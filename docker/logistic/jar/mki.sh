#!/bin/bash
version=1
if [ $version != 0 ]
then
    docker rmi -f shiki92/logistic_jar:latest shiki92/logistic_jar:$version
fi
let "version++"
docker build -f dockerfile -t shiki92/logistic_jar:$version .
docker tag shiki92/logistic_jar:$version shiki92/logistic_jar:latest