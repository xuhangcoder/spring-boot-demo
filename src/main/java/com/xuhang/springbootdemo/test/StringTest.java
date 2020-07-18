package com.xuhang.springbootdemo.test;

import java.util.*;

/**
 * @author xuhang
 * @date 2019/5/21 10:52
 */
public class StringTest {
    public static  String stringReverse(String str) {

        if (str == null || "".equals(str)) {
            return str;
        }
        return str.charAt(str.length() - 1) + stringReverse(str.substring(0, str.length() - 1));
    }

    static {
        Map  map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

//        String str = "java Hello world";
//        System.out.println("转换后的字符串"+stringReverse(str));
//        System.out.println(Math.round(-1.5));
//        String[] strs = {"abc","cde","vfr"};
//        List<String> strings = Arrays.asList(strs);
//        strings.forEach(a->{
//            System.out.println(a);
//        });

        String s1 = new String("1") + new String("1");

        s1.intern();
        String s2 = "11";
        System.out.println(s1 == s2);


    }
}
