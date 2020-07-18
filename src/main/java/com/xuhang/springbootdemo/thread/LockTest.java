package com.xuhang.springbootdemo.thread;

/**
 * @author：xuhang
 * @description：
 * @date：2018/10/31 16:46
 */
public class LockTest {
    public static void main(String[] args) {
        final Object lock = new Object();
        //创建两个线程
        Runnable t1= new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(1);
                    try {
                        lock.wait();//一旦线程通过wait进入等待，不会自己醒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(2);
                }
            }
        };
        Runnable t2= new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(3);
                    try {
                        Thread.sleep(3000);
                        lock.notify();//唤醒lock
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(4);
                }
            }
        };
        new Thread(t1).start();
        new Thread(t2).start();

    }
}
