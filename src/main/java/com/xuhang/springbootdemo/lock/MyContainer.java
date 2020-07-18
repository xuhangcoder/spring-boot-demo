package com.xuhang.springbootdemo.lock;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @author xuhang
 * @date 2020/4/16 16:29
 */
public class MyContainer<T> {

    private LinkedList<T> lists = new LinkedList<T>();
    private static final Integer MAX = 10;


    private int count = 0;

    public synchronized void put(T t) {
        while (lists.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lists.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get() {
        while (lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T t = lists.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public synchronized int getCount() {
        return this.count;
    }

    public static void main(String[] args) {
        MyContainer<Object> container = new MyContainer<>();

        for (int i = 0; i <= 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName()+"拿到了"+container.get());
                }
            },"c"+String.valueOf(i)).start();
        }
        
         try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}

         for (int i = 1; i <= 2; i++) {
             new Thread(()->{
                 for (int j = 0; j < 25; j++) {
                     container.put(Thread.currentThread().getName()+"生产的对象");
                 }
             },"p"+String.valueOf(i)).start();
         }


    }

}
