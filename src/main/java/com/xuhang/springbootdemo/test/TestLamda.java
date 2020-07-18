package com.xuhang.springbootdemo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author xuhang
 * @date 2020/4/17 11:41
 */
public class TestLamda {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("88888888");
        list.add(user);

        User user1 = new User();
        user1.setName("3456789");
        list.add(user1);

        User user2 = new User();
        user2.setName("4567898765");

        list.add(user2);
        User user3 = new User();
        user3.setName("456435345");

        list.add(user3);

        for (User u : list) {
            System.out.println(u.toString());
        }

        List<User> collect = list.stream().filter(e -> "88888888".equalsIgnoreCase(e.getName())).collect(Collectors.toList());
        System.out.println(collect.size());
        for (User user4 : collect) {
            System.out.println(user4.getName());

        }
    }




}
