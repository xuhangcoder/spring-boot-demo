package com.xuhang.springbootdemo.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xuhang
 * @date 2020/4/9 14:38
 */
public class Thread_Support {


    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] CI = "1234567".toCharArray();
        char[] CA = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : CI) {
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();

            }
        }, "t1");

         t2 = new Thread(() -> {
            for (char c : CA) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);

            }
        }, "t2");

         t1.start();
         t2.start();


    }
}
