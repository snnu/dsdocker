#!/bin/bash
export version=2
docker rmi -f shiki92/foundation_jar:latest shiki92/foundation_jar:$version
let "version++"
docker build -f dockerfile -t shiki92/foundation_jar:$version .
docker tag shiki92/foundation_jar:$version shiki92/foundation_jar:latest