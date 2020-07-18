package com.xuhang.springbootdemo.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author xuhang
 * @date 2019/4/10 12:06
 */
public class ConcurrentMap {

    public static void main(String[] args) {
//        Map<String, String> map = new ConcurrentHashMap<>();
        Map<String, String> map  = new ConcurrentSkipListMap<>();
//        Map<String, String> map =
//        Map<String, String> map = new HashMap<>();
        Random r = new Random();
        Thread[] ths = new Thread[1000];
        CountDownLatch latch = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(() ->{
                for (int j = 0; j < 100000; j++) {
                    map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
                }
                latch.countDown();
            });
        }

        Arrays.asList(ths).forEach(t -> t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
