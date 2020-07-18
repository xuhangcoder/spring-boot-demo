package com.xuhang.springbootdemo.thread;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xuhang
 * @date 2018/12/12 11:42
 */
public class Thread_ParallelComputing {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        long start = System.currentTimeMillis();
//        List<Integer> prime = getPrime(1, 900000);
        long end = System.currentTimeMillis();
//        System.out.println(end - start);

        ExecutorService service = Executors.newFixedThreadPool(6);

        MyTask t1 = new MyTask(1, 200000);
        MyTask t2 = new MyTask(200001, 500000);
        MyTask t3 = new MyTask(500001, 700000);
        MyTask t4 = new MyTask(700001, 900000);

        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);

        start = System.currentTimeMillis();

        f1.get();
        f2.get();
        f3.get();
        f4.get();
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    static class MyTask implements Callable<List<Integer>>{
        int startPos, endPos;
        MyTask(int s,int e){

            this.startPos = s;
            this.endPos = e;
        }


        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r = getPrime(startPos, endPos);
            return r;
        }
    }


    static boolean isPrime(int num){
        for (int i = 2; i < num/2; i++) {
            if (num % i == 0)  {
                return false;
            }
        }
        return true;
    }

    static List<Integer> getPrime(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start ; i < end ; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
