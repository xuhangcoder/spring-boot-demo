package com.xuhang.springbootdemo.thread;

import java.util.concurrent.*;

/**
 * @author xuhang
 * @date 2021/3/16 16:14
 */
public class ThreadPoolAfterExecute {




    static class MyThreadPoolAfterExecute extends ThreadPoolExecutor{


        public MyThreadPoolAfterExecute(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            int i = 1 / 0;
        }
    }

    public static void main(String[] args) {
        MyThreadPoolAfterExecute pool = new MyThreadPoolAfterExecute(1, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("糟糕，有异常捉到了");
                    }
                });
                return thread;
            }
        }, new ThreadPoolExecutor.CallerRunsPolicy());

        pool.execute(()-> System.out.println(1));
        pool.execute(()-> System.out.println(1));
        pool.execute(()-> System.out.println(1));
        pool.execute(()-> System.out.println(1));
        pool.execute(()-> System.out.println(1));
    }

}
