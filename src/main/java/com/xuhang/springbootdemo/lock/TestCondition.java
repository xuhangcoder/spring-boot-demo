package com.xuhang.springbootdemo.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private  Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    private int number = 1;

    public void print(int x) {

          lock.lock();
               try {


                   if (x == 5) {
                       while (number != 1) {
                           c1.await();

                       }
                       for (int i = 1; i <= 5; i++) {
                           System.out.println(Thread.currentThread().getName()+i);
                       }
                       number = 2;
                       c2.signal();
                   }
                   if (x == 10) {
                       while (number != 2) {
                           c2.await();

                       }
                       for (int i = 1; i <= 10; i++) {
                           System.out.println(Thread.currentThread().getName()+i);
                       }
                       number = 3;
                       c3.signal();
                   }
                   if (x == 15) {
                       while (number != 3) {
                           c3.await();

                       }
                       for (int i = 1; i <= 15; i++) {
                           System.out.println(Thread.currentThread().getName()+i);
                       }
                       number = 1;
                       c1.signal();
                   }


              } catch (Exception e) {
                  e.printStackTrace();
              }finally {
                  lock.unlock();
          }
    }


}
/**
 * @author xuhang
 * @date 2020/3/17 14:41
 */
public class TestCondition {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {

                shareData.print(5);
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {

                shareData.print(10);
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {

                shareData.print(15);
            }
        },"C").start();
    }

}
