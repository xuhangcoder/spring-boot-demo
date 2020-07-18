package com.xuhang.springbootdemo.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Mycacah{
    private volatile Map map = new HashMap<>();

    ReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void put(String key ,Object value) {
      rwlock.writeLock().lock();
         try {
             System.out.println(Thread.currentThread().getName() + "正在写入：" + key);
             try { TimeUnit.MILLISECONDS.sleep(300);} catch (InterruptedException e) {e.printStackTrace(); }
             map.put(key, value);
             System.out.println(Thread.currentThread().getName()+"写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            rwlock.writeLock().unlock();
    }
    }

    public void get(String key) {

          rwlock.readLock().lock();
               try {
                   System.out.println(Thread.currentThread().getName() + "正在读取：" );
                   try {
                       TimeUnit.MILLISECONDS.sleep(300);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   Object result = map.get(key);
                   System.out.println(Thread.currentThread().getName()+"读取完成："+result);
              } catch (Exception e) {
                  e.printStackTrace();
              }finally {
                  rwlock.readLock().unlock();
          }
    }
}

/**
 * @author xuhang
 * @date 2020/3/3 10:32
 */
public class ReadWriteLockTest {



    public static void main(String[] args) {

        Mycacah mycacah = new Mycacah();

        for (int i = 0; i <= 5 ; i++) {
            final int  temInt = i;
            new Thread(()->{
                mycacah.put(temInt+" ",temInt+" ");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i <= 5 ; i++) {
            final int  temInt = i;
            new Thread(()->{
                mycacah.get(temInt+" ");
            },String.valueOf(i)).start();
        }

    }

}
