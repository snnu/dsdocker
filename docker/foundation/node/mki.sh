#!/bin/bash
version=1
docker rmi -f shiki92/foundation_node:latest shiki92/foundation_node:$version
let "version++"
docker build -f dockerfile -t shiki92/foundation_node:$version .
docker tag shiki92/foundation_node:$version shiki92/foundation_node:latest