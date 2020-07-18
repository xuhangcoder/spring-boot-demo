package com.xuhang.springbootdemo.thread;

import com.mysql.cj.util.TimeUtil;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author xuhang
 * @date 2018/12/12 9:51
 */
public class Thread_ArrayBlockingQueue {
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);
    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

//        strs.put("aaa");
//        strs.add("aaa");
        boolean aaa = strs.offer("aaa", 3, TimeUnit.SECONDS);
        System.out.println(aaa);
        System.out.println(strs.size());
    }

}
