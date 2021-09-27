#!/bin/bash

/usr/sbin/sshd

sleep 5

mkdir /opt/sh/hadoop/logs

java -Xmx128M -Xms128M -XX:MaxDirectMemorySize=256M -jar /opt/sh/hadoop/mate/hadoop-mate.jar >/opt/sh/hadoop/logs/hadoop_mate.stdout.log 2>/opt/sh/hadoop/logs/hadoop_mate.stderr.log
tail -f /dev/null