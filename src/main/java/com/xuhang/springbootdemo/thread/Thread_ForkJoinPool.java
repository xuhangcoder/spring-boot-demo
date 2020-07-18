package com.xuhang.springbootdemo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author xuhang
 * @date 2018/12/12 14:57
 */

class MyTask extends RecursiveTask<Integer>{

    private static final Integer MAX = 10;

    private int begin;
    private int end;

    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if ((end - begin) <= MAX) {
            for (int i = begin; i <= end; i++) {
                result = result + i;
        }
        }else {

            int middle = (end + begin) / 2;
            MyTask myTask01  = new MyTask(begin, middle);
            MyTask myTask02  = new MyTask(middle + 1, end);

            myTask01.fork();
            myTask02.fork();
            result =  myTask01.join()+ myTask02.join();
        }


        return result;
    }
}



public class Thread_ForkJoinPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyTask myTask = new MyTask(0, 100);

        ForkJoinPool threadPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = threadPool.submit(myTask);
        System.out.println(submit.get());
        threadPool.shutdown();
    }

}
