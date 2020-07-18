package com.xuhang.springbootdemo.thread;

/**
 * @author：xuhang
 * @description：
 * @date：2018/10/31 16:51
 */
public class DeadLockTest implements Runnable {

    private static Father father = new Father();
    private static Child child = new Child();
    private boolean flag = false;



    @Override
    public void run() {
        if(flag){
            //父亲
            synchronized (father) {
                father.say();
                synchronized (child) {
                    father.get();
                }
            }
        }else
        {
            //孩子
            synchronized (child) {
                child.say();
                synchronized (father) {
                    child.get();
                }
            }
        }
    }
    public static void main(String[] args) {
        DeadLockTest d1= new DeadLockTest();
        DeadLockTest d2= new DeadLockTest();
        d1.flag=true;
        d2.flag=false;
        new Thread(d1).start();
        new Thread(d2).start();
    }

}
