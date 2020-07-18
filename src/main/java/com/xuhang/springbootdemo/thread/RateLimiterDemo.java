package com.xuhang.springbootdemo.thread;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xuhang
 * @date 2020/5/28 14:20
 */
public class RateLimiterDemo {

    private static RateLimiter limiter = RateLimiter.create(25);

    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            if (!limiter.tryAcquire()) {
                continue;
            }
            new Thread(new Task()).start();
        }

    }

    public class RejectedMethod implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        }
    }
}
