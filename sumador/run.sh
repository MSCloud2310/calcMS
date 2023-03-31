#!/bin/bash
NUM_SERVERS=10
for ((i=9090;i<=9090+NUM_SERVERS;i++)); do
    # echo $i
    SERVER_PORT=$i mvn spring-boot:run &

done