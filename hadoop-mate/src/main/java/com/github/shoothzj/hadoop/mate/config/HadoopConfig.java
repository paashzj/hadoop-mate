package com.github.shoothzj.hadoop.mate.config;

import com.github.shoothzj.hadoop.mate.module.DeployType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author hezhangjian
 */
@Configuration
@Service
public class HadoopConfig {

    @Value("${DEPLOY_TYPE:PSEUDO}")
    public DeployType deployType;

}
