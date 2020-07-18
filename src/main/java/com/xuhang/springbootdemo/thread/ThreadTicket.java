package com.xuhang.springbootdemo.thread;

/**
 * @author：xuhang
 * @description：
 * @date：2018/10/31 16:02
 */
public class ThreadTicket extends Thread {
    private int ticketnum=5;
    private String name;
    public ThreadTicket(String name) {
        super();
        this.name = name;
    };
    @Override
    public void run() {
        for (int i = 1; i <=5; i++) {
            System.out.println(name+"卖票"+ticketnum--);
        }
    }

    public static void main(String[] args) {
        //使用金庸武侠里的美女角色怀念一下金庸大侠
        ThreadTicket zhaomin = new ThreadTicket("赵敏");
        ThreadTicket xiaozhao = new ThreadTicket("小昭");
        //启动两个线程
        zhaomin.start();
        xiaozhao.start();

    }

}
