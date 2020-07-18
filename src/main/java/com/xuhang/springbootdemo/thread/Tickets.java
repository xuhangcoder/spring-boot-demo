package com.xuhang.springbootdemo.thread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xuhang
 * @date 2018/12/11 10:18
 */
public class Tickets {
  static Queue<String> tickets =   new ConcurrentLinkedQueue<>();

  static {
      for (int i = 0; i < 1000000; i++) {
          tickets.add("票的编号是：" + i);
      }
  }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    String s = tickets.poll();
                    if (s == null){ break;}
                    else {System.out.println("销售了一张票 "+s );}
                }
            }).start();
        }
    }

}
