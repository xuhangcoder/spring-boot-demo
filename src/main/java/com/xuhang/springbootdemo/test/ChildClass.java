package com.xuhang.springbootdemo.test;

/**
 * @author xuhang
 * @date 2020/4/4 14:24
 */
public class ChildClass extends ParentClass{
    public ChildClass(){
        System.out.println("X");
    }
    public static void staticMethod() {
        System.out.println("Y");
    }
    @Override
    public void method() {
        System.out.println("Z");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}
