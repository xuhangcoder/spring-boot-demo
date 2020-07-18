package com.xuhang.springbootdemo.lock;

import com.xuhang.springbootdemo.thread.DeadLockTest;

import java.util.concurrent.TimeUnit;

/**
 * @author xuhang
 * @date 2020/3/5 17:07
 */

class TestDeadLock implements Runnable{

    private String lockA;
    private String lockB;

    public TestDeadLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+"获得："+lockA +"尝试获得："+lockB);
             try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"获得："+lockB +"尝试获得："+lockA);

            }

        }

    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new TestDeadLock(lockA,lockB)).start();
        new Thread(new TestDeadLock(lockB,lockA)).start();
    }





}
