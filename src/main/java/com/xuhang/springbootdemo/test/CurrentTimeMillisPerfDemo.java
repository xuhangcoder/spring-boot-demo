package com.xuhang.springbootdemo.test;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author xuhang
 * @date 2019/9/6 11:30
 */
public class CurrentTimeMillisPerfDemo {

    private static final int COUNT = 100;

    public static void main(String[] args) throws InterruptedException {

        long beginTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            System.currentTimeMillis();
//            new HashMap<>();
        }

        long elapsedTime = System.nanoTime() - beginTime;
        System.out.println(elapsedTime);

        CountDownLatch startLarch =  new CountDownLatch(1);
        CountDownLatch endLatch =  new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {
            new Thread(()->{
                try {
                    startLarch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    endLatch.countDown();
                }
//                System.currentTimeMillis();
                new HashMap<>();
            }).start();
        }

        beginTime = System.nanoTime();
        startLarch.countDown();
        endLatch.await();
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println(elapsedTime);


    }


}
