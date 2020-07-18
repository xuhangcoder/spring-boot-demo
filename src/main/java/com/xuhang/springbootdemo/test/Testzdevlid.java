package com.xuhang.springbootdemo.test;

/**
 * @author xuhang
 * @date 2019/7/16 10:28
 */
public class Testzdevlid {

    private static final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
    private static final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;

    public static void main(String[] args) {
        System.out.println(MICROS_PER_DAY/MILLIS_PER_DAY);
    }
}
