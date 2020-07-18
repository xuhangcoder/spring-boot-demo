package com.xuhang.springbootdemo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuhang
 * @date 2020/4/17 15:02
 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
          lock.lock();
               try {

              } catch (Exception e) {
                  e.printStackTrace();
              }finally {
                  lock.unlock();
          }
    }
}
