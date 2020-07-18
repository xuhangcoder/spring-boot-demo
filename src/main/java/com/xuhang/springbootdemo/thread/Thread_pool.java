package com.xuhang.springbootdemo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.SocketHandler;

/**
 * @author xuhang
 * 线程池
 * @date 2018/12/12 10:14
 */
public class Thread_pool {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 999; i++) {
            service.execute(()->{
                for (int j = 0; j < 3; j++) {
                    if (j == 2) {
                        System.out.println("跳过输出。。。。");
                        continue;
                    }

                    System.out.println(j);
                }
            });
        }



    }

}
