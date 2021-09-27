package com.github.shoothzj.hadoop.mate.constant;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author hezhangjian
 */
@Slf4j
public class PathConst {

    public static final String HADOOP_HOME = System.getenv("HADOOP_HOME");

    public static final String HADOOP_CONFIG_DIR = HADOOP_HOME + File.separator + "conf";

    public static final String HADOOP_MATE = HADOOP_HOME + File.separator + "mate";

    public static final String HADOOP_SCRIPTS = HADOOP_MATE + File.separator + "scripts";

    public static final String HADOOP_START_DATA_SCRIPT = HADOOP_SCRIPTS + File.separator + "start-hadoop-data.sh";

    public static final String HADOOP_START_NAME_SCRIPT = HADOOP_SCRIPTS + File.separator + "start-hadoop-name.sh";

    public static final String HADOOP_START_PSEUDO_SCRIPT = HADOOP_SCRIPTS + File.separator + "start-hadoop-pseudo.sh";


}
