package com.xuhang.springbootdemo.thread;

import java.util.concurrent.*;

/**
 * @author xuhang
 * @date 2018/12/12 14:24
 */
public class Thread_SiglePool {
    public static void main(String[] args) {
        int num = Runtime.getRuntime().availableProcessors();
        System.out.println(Runtime.getRuntime().availableProcessors());


        ExecutorService  threadPool = new ThreadPoolExecutor(
                2,
                num,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            threadPool.execute(()->{
                System.out.println("闫高鹏是我儿子");
            });
        }finally {
            threadPool.shutdown();
        }


    }



}
