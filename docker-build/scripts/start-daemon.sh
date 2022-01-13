#!/bin/bash

/usr/sbin/sshd

sleep 5

mkdir -p $HADOOP_HOME/logs

java -Xmx128M -Xms128M -XX:MaxDirectMemorySize=256M -jar $HADOOP_HOME/mate/hadoop-mate.jar >>$HADOOP_HOME/logs/hadoop_mate.stdout.log 2>>$HADOOP_HOME/logs/hadoop_mate.stderr.log
