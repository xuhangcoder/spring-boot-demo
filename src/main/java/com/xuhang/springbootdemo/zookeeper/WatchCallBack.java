package com.xuhang.springbootdemo.zookeeper;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author xuhang
 * @date 2020/5/11 11:29
 */
public class WatchCallBack implements Watcher,AsyncCallback.StatCallback,AsyncCallback.DataCallback{

    ZooKeeper zk;
    MyConf myConf;
    CountDownLatch cc = new CountDownLatch(1);

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public MyConf getMyConf() {
        return myConf;
    }

    public void setMyConf(MyConf myConf) {
        this.myConf = myConf;
    }

    public void await() {
        zk.exists("/AppConf", this, this, "xuhang");
        try {
            cc.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
        if (bytes != null) {
            String data = new String(bytes);
            myConf.setConf(data);
            cc.countDown();

        }

    }

    @Override
    public void processResult(int i, String s, Object o, Stat stat) {
        if (stat != null) {
            zk.getData("/AppConf", this, this, "xuhang");
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        switch (watchedEvent.getType()) {
            case None:
                break;
            case NodeCreated:zk.getData("/AppConf", this, this, "xuhang");
                break;
            case NodeDeleted:
                myConf.setConf("");
                cc = new CountDownLatch(1);
                break;
            case NodeDataChanged: zk.getData("/AppConf", this, this, "xuhang");
                break;
            case NodeChildrenChanged:
                break;
        }
    }
}
