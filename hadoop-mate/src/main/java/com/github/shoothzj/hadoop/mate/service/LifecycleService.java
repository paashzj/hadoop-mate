package com.github.shoothzj.hadoop.mate.service;

import com.github.shoothzj.hadoop.mate.config.HadoopConfig;
import com.github.shoothzj.hadoop.mate.constant.PathConst;
import com.github.shoothzj.javatool.util.ShellUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author hezhangjian
 */
@Slf4j
@Service
public class LifecycleService {

    @Autowired
    private HadoopConfig hadoopConfig;

    @PostConstruct
    public void init() throws Exception {
        // change config
        genConfig();
        // start hadoop
        startHadoop();
    }

    /**
     *
     */
    public void genConfig() throws Exception {

    }

    public void startHadoop() throws Exception {
        switch (hadoopConfig.deployType) {
            case DATA:
                ShellUtil.executeCmd("bash -x " + PathConst.HADOOP_START_DATA_SCRIPT);
                break;
            case NAME:
                ShellUtil.executeCmd("bash -x " + PathConst.HADOOP_START_NAME_SCRIPT);
                break;
            case PSEUDO:
                ShellUtil.executeCmd("bash -x " + PathConst.HADOOP_START_PSEUDO_SCRIPT);
                break;
            default:
                break;
        }
    }

}
