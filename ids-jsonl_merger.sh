#!/bin/bash

# $1 and $2 need to be the results of the java_flow_agent execution :: https://github.com/Evref-BL/Java-Flow-Agent
# $3 need to be a .jsonl file

IDS_SOURCES=$1
FLOW_SOURCES=$2
OUTPUT_FILE=$3

cp $FLOW_SOURCES $OUTPUT_FILE

# for each line the ids.properties, we took the id and the value
# and we replace each instance of this id in the jsonl file with this value
while read line; do
    id=$(echo $line | cut -d'=' -f2)
    val=$(echo $line | cut -d'=' -f1)
    echo "id: " $id " val: " $val

    sed -i "s~\"method\":$id}~\"method\":\"$val\"}~g" $OUTPUT_FILE
done < $IDS_SOURCES