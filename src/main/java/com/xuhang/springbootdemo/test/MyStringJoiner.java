package com.xuhang.springbootdemo.test;

import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * @author xuhang
 * @date 2021/3/2 14:07
 */
public class MyStringJoiner {
    public static void main(String[] args) {

        StringJoiner stringJoiner = new StringJoiner(",","{","}");
        IntStream.range(1,20).forEach((i)->{stringJoiner.add(i+"");});
        System.out.println(stringJoiner.toString());
//        stringJoiner.setEmptyValue("123");
        stringJoiner.merge(stringJoiner);
        System.out.println(stringJoiner.toString());
    }
}
