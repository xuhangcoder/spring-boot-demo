package com.xuhang.springbootdemo.thread;

/**
 * @author：xuhang
 * @description：
 * @date：2018/10/31 16:09
 */
public class RunnableTicket implements Runnable {
    private int ticketnum=100;
    @Override
    public void run() {
        for (int i = 1; i <=ticketnum; i++) {
            synchronized (this) {

                        for (int j = 0; j < 3; j++) {
                            if (j == 2) {
                                System.out.println("跳过输出。。。。");
                                continue;
                            }
                            System.out.println(j);

                    };
            }
        }
    }

    public static void main(String[] args) {
        RunnableTicket rt = new RunnableTicket();
        new Thread(rt,"售票员赵敏").start();
        new Thread(rt,"售票员小昭").start();

    }

}

