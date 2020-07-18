package com.xuhang.springbootdemo.jvm;

import com.xuhang.springbootdemo.dto.User;

/**
 * @author xuhang
 * @date 2020/4/17 15:17
 */
public class TestThreadLocal {

    public static final ThreadLocal<User> userMap = new ThreadLocal<>();

    public static void main(String[] args) {
        userMap.set(new User());

    }
}
