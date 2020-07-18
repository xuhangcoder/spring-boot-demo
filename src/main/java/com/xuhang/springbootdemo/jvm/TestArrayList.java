package com.xuhang.springbootdemo.jvm;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xuhang
 * @date 2020/4/4 15:24
 */
public class TestArrayList {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList();
//        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
