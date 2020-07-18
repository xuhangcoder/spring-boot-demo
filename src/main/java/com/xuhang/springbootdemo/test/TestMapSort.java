package com.xuhang.springbootdemo.test;

import io.swagger.models.auth.In;

import java.util.*;

/**
 * @author xuhang
 * @date 2019/10/31 10:58
 */
public class TestMapSort {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap();
        map.put(1, 8);
        map.put(2, 12);
        map.put(3, 53);
        map.put(4, 33);
        map.put(5, 11);
        map.put(6, 3);
        map.put(7, 3);
        List<Map.Entry<Integer,Integer>> list = new ArrayList(map.entrySet());
        list.sort( (o1, o2) -> (o2.getValue() - o1.getValue()));
        System.out.println(list.get(0).getKey());

    }
}
