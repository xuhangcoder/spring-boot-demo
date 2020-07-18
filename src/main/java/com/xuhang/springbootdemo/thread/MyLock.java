package com.xuhang.springbootdemo.thread;


import java.util.LinkedList;


public class MyLock<T>{

    private final LinkedList<T> lists = new LinkedList<T>();
    private final int MAX = 10;
    private int count =0;


    public synchronized void put(T t){
        while (lists.size() == MAX){
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

}
