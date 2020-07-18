package com.xuhang.springbootdemo.thread;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author xuhang
 * @date 2018/12/12 9:36
 * 无界队列。
 */
public class Thread_LinkedBlockingQueue {

    static LinkedBlockingQueue<String> strs =  new LinkedBlockingQueue();

    static Random r = new Random();

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    strs.put("厨师做好了第"+i+"份菜");
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"p1").start();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                for (;;){
                    try {
                        System.out.println(strs.take()+Thread.currentThread().getName()+"号服务员上菜");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"c"+i).start();
        }
    }

}
