package com.xuhang.springbootdemo.thread;

import java.util.concurrent.*;

/**
 * @author xuhang
 * @date 2020/5/28 15:49
 */
public class ThreadStackInfo {
    public static class DivTask implements Runnable{
        private int a;
        private int b;

        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double re = a / b;
            System.out.println(re);
        }
    }

    public  static  class  TrackThreadPool extends ThreadPoolExecutor{

        public TrackThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        public void execute(Runnable command) {
            super.execute(wrap(command,clientTrace(),Thread.currentThread().getName()));
        }

        @Override
        public Future<?> submit(Runnable task) {
            return super.submit(wrap(task,clientTrace(),Thread.currentThread().getName()));
        }

        private Exception clientTrace() {
            return new Exception("Client stack trace");
        }

        private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName) {
            return new Runnable() {
                @Override
                public void run() {
                    try {
                        task.run();
                    } catch (Exception e) {
                        clientStack.printStackTrace();
                        throw e;
                    }
                }
            };
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new TrackThreadPool(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 5; i++) {
            Future<?> submit = executor.submit(new DivTask(100, i));
            submit.get();
        }
    }
}
