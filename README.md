# IDS-JSONL_Merger

## Java

A java application that replaces each id from thread.jsonl with the corresponding value which is defined inside ids.properties. Both of these files are the outputs of the [java_flow_agent](https://github.com/Evref-BL/Java-Flow-Agent).

3 inputs :
- The ids.properties file that contains the association : value <-> id
- the file that contains the execution flow with id (.jsonl)
- the destination file where to write the result (.jsonl)

1 outputs :
- The result of the merge is written inside the destination file

## Bash

This is the first version of the merge; the inputs and outputs are the same.

## Example

Java:
``` Java
java -jar path/to/.jar path/to/ids.properties path/to/thread.jsonl path/where/to/save/theResult.jsonl
```

Bash
``` Bash
./bash_version/ids-jsonl_merger.sh path/to/ids.properties path/to/thread.jsonl path/where/to/save/theResult.jsonl
```