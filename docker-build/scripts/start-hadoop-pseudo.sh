#!/bin/bash

source /etc/profile
cp $HADOOP_HOME/mate/conf/pseudo/core-site.xml $HADOOP_HOME/etc/hadoop/core-site.xml
cp $HADOOP_HOME/mate/conf/pseudo/hdfs-site.xml $HADOOP_HOME/etc/hadoop/hdfs-site.xml
$HADOOP_HOME/bin/hdfs namenode -format
$HADOOP_HOME/sbin/start-dfs.sh
