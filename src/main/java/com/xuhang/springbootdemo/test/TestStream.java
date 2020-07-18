package com.xuhang.springbootdemo.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xuhang
 * @date 2019/8/22 17:54
 */
public class TestStream {
    public static void main(String[] args) {

        List<String> collect = Stream.of("a", "b", "Hello").map(string -> string.toUpperCase()).collect(Collectors.toList());

        System.out.println(collect);


    }
}
