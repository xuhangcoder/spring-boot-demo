package com.xuhang.springbootdemo.test;

/**
 * @author xuhang
 * @date 2020/4/4 14:23
 */
public class ParentClass {
    public ParentClass(){
        System.out.println("A");
    }

    public static void staticMethod() {
        System.out.println("B");
    }
    public void method() {
        System.out.println("C");

    }
}
