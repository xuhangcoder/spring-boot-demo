package com.xuhang.springbootdemo.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author xuhang
 * @date 2020/3/19 13:58
 */
public class CyclieBarrie {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println("******哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        });

        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"来啦");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }



    }
}
