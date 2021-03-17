package com.xuhang.springbootdemo.test;

/**
 * @author xuhang
 * @date 2021/2/22 10:24
 */
public class TestAlgo {
    public static void main(String[] args) {

        System.out.println(gcd(1989L, 1590L));
    }


    public static long gcd(long m, long n) {

        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }
}
