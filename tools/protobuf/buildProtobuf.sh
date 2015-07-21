#!/bin/sh

rm com -rf 1>/dev/null 2>&1
for i in *.proto
do
    protoc -I=. --java_out=. $i
    if [ "$?" -eq 0 ]
    then
        echo "已生成$"
    else
        exit 1
    fi
done

