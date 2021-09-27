#!/bin/bash

source /etc/profile
cp /opt/sh/mate/conf/core-site.xml /opt/sh/hadoop/etc/hadoop/core-site.xml
cp /opt/sh/mate/conf/hdfs-site.xml /opt/sh/hadoop/etc/hadoop/hdfs-site.xml
/opt/sh/hadoop/bin/hdfs --daemon start datanode
