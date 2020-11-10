#!/bin/bash
export version=5
docker rmi -f shiki92/platform_jar:latest shiki92/platform_jar:$version
let "version++"
docker build -f dockerfile -t shiki92/platform_jar:$version .
docker tag shiki92/platform_jar:$version shiki92/platform_jar:latest