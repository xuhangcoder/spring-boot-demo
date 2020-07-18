package com.xuhang.springbootdemo.test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author xuhang
 * @date 2019/4/9 17:05
 */
public class TestList {
    public static void main(String[] args) {
            String[] strs = {"1","4","3","3"};
        List<String> list = Arrays.asList(strs);
        List<String> lists = new ArrayList<>(list);
        lists.add(0, "0");
        System.out.println("去重前：");
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i));
        }
        System.out.println();
        Set set = new HashSet();
        List<String> newList = new ArrayList<>();
        for (String str1 : lists) {
            //set能添加进去就代表不是重复的元素
            if (set.add(str1)) {
                newList.add(str1);
            }
        }
        lists.clear();
        lists.addAll(newList);
        System.out.println("去重后：");
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
