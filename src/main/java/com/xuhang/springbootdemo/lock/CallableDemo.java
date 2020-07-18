package com.xuhang.springbootdemo.lock;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Mythread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("*************come in ");
        return 1024;
    }
}
/**
 * @author xuhang
 * @date 2020/3/4 15:55
 */
public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask(new Mythread());

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.get());

    }

}
