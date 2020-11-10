#!/bin/bash
docekr rm -f $(docker ps -aq)
docker-compose up
