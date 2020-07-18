package com.xuhang.springbootdemo.test;

import java.util.ArrayList;

/**
 * @author xuhang
 * @date 2019/12/5 10:13
 */
public class TestIterator {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (Object o : list) {
            if (o.equals(3)) {
                list.remove(o);
            }
        }
    }
}
