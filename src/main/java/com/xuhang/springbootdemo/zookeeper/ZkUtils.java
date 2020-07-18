package com.xuhang.springbootdemo.zookeeper;

import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author xuhang
 * @date 2020/5/11 10:54
 */
public class ZkUtils {

    public static ZooKeeper zk;

    private static String address = "192.168.60.100:2181,192.168.60.131:2181,192.168.60.102:2181/testConf";

    private static DefaultWatch watcher = new DefaultWatch();
    private static CountDownLatch init = new CountDownLatch(1);
    public static ZooKeeper getZk() {

        try {
            zk = new ZooKeeper(address, 1000, watcher);
            watcher.setCc(init);
            init.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zk;
    }
}
