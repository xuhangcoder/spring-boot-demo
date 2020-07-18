package com.xuhang.springbootdemo.lock;

/**
 * @author xuhang
 * @date 2020/3/3 17:13
 */
public class CountDownLatch {


    public static void main(String[] args) throws InterruptedException {

        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 被灭");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"秦国一统华夏");
    }


}
