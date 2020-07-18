package com.xuhang.springbootdemo.test;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * @author xuhang
 * @date 2019/6/25 17:57
 */
public class TestSyncQueue {
    public static void main(String[] args) throws InterruptedException {
//        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
//        System.out.println(queue.offer(1) + " ");
//        System.out.println(queue.offer(2) + " ");
//        System.out.println(queue.offer(3) + " ");
//        System.out.println(queue.take()+" ");
//        System.out.println(queue.size());

//        ArrayList<Object> master = new ArrayList<>();
//        master.add("one");
//        master.add("two");
//        master.add("three");
//
//        List<Object> salve = master.subList(1, 2);
//        master.add("four");
//        for (Object o:salve) {
//            System.out.println(o);
//        }

//        float a = 0.7f;
//        float b = 0.6f;
//        System.out.println(a-b);

//        Random random = new Random();
//        boolean b = random.nextBoolean();
//        Number result = (b || !b) ? new Integer(3) : new Float(1);
//
//        System.out.println(result);

        Random random = new Random();
        int i = random.nextInt();
        if (Math.round(i) != i) {
            System.out.println("haha");
        }


    }
}
