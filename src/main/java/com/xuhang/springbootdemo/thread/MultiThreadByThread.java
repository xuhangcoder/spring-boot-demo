package com.xuhang.springbootdemo.thread;

import java.io.IOException;

/**
 * @author：xuhang
 * @description：通过继承Thread类实现多线程。
 * @date：2018/10/31 15:25
 */
public class MultiThreadByThread extends Thread {
    private String ip;
    public MultiThreadByThread(String ip) {
        super();
        this.ip = ip;
    }
    @Override
    public void run() {
        try {
            PingHost.checkHost(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


