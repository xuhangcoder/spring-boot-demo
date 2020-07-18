package com.xuhang.springbootdemo.jvm;

import java.lang.ref.WeakReference;

/**
 * @author xuhang
 * @date 2020/3/23 14:27
 */
public class TestWeakReference {
    public static void main(String[] args) {
        WeakReference weakReference = new WeakReference<>(new VmoPtions());

        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());

        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        threadLocal.set("haha");
        threadLocal.remove();
    }
}
