package com.xuhang.springbootdemo.thread;

import java.io.IOException;

/**
 * @author：xuhang
 * @description：通过实现Runnable接口并重写run方法实现多线程
 * @date：2018/10/31 15:53
 */
public class MultiThreadByRunnable implements Runnable {
    private String ip;
    public MultiThreadByRunnable(String ip) {
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
