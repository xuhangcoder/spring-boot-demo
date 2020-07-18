package com.xuhang.springbootdemo.jvm;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @author xuhang
 * @date 2020/3/23 14:02
 */
public class Test_SoftReference {
    public static void main(String[] args) {

        SoftReference<byte[]> m = new SoftReference<byte[]>(new byte[1024 * 1024 * 5]);

        System.out.println(m.get());

        System.gc();

         try {
             TimeUnit.MILLISECONDS.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}

        System.out.println(m.get());
        System.gc();

        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(m.get());


    }
}
