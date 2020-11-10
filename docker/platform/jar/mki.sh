#!/bin/bash
version=0
docker rmi shiki92/platform_jar:latest shiki92/platform_jar:$version
let "version++"
docker build -f dockerfile -t shiki92/platform_node:$version .
docker tag shiki92/platform_jar:$version shiki92/platform_jar:latest