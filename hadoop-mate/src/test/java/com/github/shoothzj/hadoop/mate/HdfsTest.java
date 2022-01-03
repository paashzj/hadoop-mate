package com.github.shoothzj.hadoop.mate;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

/**
 * windows: https://cwiki.apache.org/confluence/display/HADOOP2/WindowsProblems
 * @author shoothzj
 */
public class HdfsTest {

    MiniDFSCluster hdfsCluster;

    String hdfsUrl;

    @BeforeEach
    public void init() throws Exception {
        File baseDir = Files.createTempDirectory("hadoop").toFile().getAbsoluteFile();
        Configuration conf = new Configuration();
        conf.set(MiniDFSCluster.HDFS_MINIDFS_BASEDIR, baseDir.getAbsolutePath());
        MiniDFSCluster.Builder builder = new MiniDFSCluster.Builder(conf);
        hdfsCluster = builder.build();
        hdfsUrl = "hdfs://localhost:" + hdfsCluster.getNameNodePort() + "/";
    }

    @Test
    public void testCreateFile() throws Exception {
        FileSystem fileSystem = FileSystem.get(acquireConfig());
        Path path = new Path("/hdfs/file-create");
        fileSystem.create(path);
        Assertions.assertTrue(fileSystem.exists(path));
    }

    private Configuration acquireConfig() {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", hdfsUrl);
        return configuration;
    }

    @AfterEach
    public void tearDown() {
        hdfsCluster.shutdown(true, true);
        hdfsCluster.close();
    }

}
