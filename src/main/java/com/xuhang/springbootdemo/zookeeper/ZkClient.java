package com.xuhang.springbootdemo.zookeeper;

import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author xuhang
 * @date 2018/12/4 15:14
 */
public class ZkClient {
    ZooKeeper zk;
    @Before
    public void conn() {
         zk = ZkUtils.getZk();
    }

    @After
    public void close() {
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getConf() {

        WatchCallBack watchCallBack = new WatchCallBack();
        watchCallBack.setZk(zk);
        MyConf myConf = new MyConf();
        watchCallBack.setMyConf(myConf);

        watchCallBack.await();

        while (true) {
            if ("".equals(myConf.getConf())) {
                System.out.println("配置丢啦");
                watchCallBack.await();
            }else {
                System.out.println(myConf.getConf());
            }
             try { TimeUnit.SECONDS.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        }
    }

}
