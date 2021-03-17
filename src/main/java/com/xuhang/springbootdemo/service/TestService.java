package com.xuhang.springbootdemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author xuhang
 * @date 2021/3/8 16:48
 */
@Service
public class TestService {

    @Async
    public void test()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我进来执行啦");
    }
}
