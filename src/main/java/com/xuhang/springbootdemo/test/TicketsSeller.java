package com.xuhang.springbootdemo.test;

import com.xuhang.springbootdemo.thread.Tickets;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xuhang
 * @date 2019/4/10 10:58
 */
public class TicketsSeller {
    //    static Vector<String> tickets = new Vector<>();
//    static List<String> tickets = new LinkedList<>();
   static Queue<String> tickets = new ConcurrentLinkedQueue<>();


    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

                new Thread(() -> {
                    while (true){
                        String s = tickets.poll();
                        if (s == null )  break;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("销售了：" + s);


                }
            }).start();

        }
    }
}
