package com.xuhang.springbootdemo.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * @author xuhang
 * @date 2020/5/28 15:16
 */
public class CoumsuerThreadPool {

    public static class Mytask implements Runnable {

        private String name;

        public Mytask(String name) {
            this.name = name;
        }



        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+"\t Thread name : "+Thread.currentThread().getName());
            
             try {
                 TimeUnit.MILLISECONDS.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
        }
    }

    public static void main(String[] args) {
        int cpuCount = Runtime.getRuntime().availableProcessors();
        BigDecimal count = new BigDecimal(cpuCount).multiply(new BigDecimal(0.8));
        ThreadPoolExecutor executor = new ThreadPoolExecutor(count.intValue(), count.intValue(),
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                new ThreadFactoryBuilder().setNameFormat("xuhang-Thread-%d").build(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "被丢弃了");
                    }
                }
        ){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行："+((Mytask)r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成："+((Mytask)r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出了");
            }
        };
        for (int i = 0; i < 500; i++) {
            Mytask myTask = new Mytask("TASK_GEYM-"+i);
            executor.execute(myTask);
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        executor.shutdown();

    }
}
