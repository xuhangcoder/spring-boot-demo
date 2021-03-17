package com.xuhang.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.xuhang.springbootdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhang
 * @date 2021/2/20 16:45
 */
@RestController
public class TestController {

    @Autowired
//    @Lazy
    private TestService testService;

    @GetMapping("testUserId")
    public void test() {
        System.out.println("controller 开始执行");
        testService.test();
        System.out.println("controller 执行完毕");
    }

    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("规格key", "规格value");
        System.out.println(JSON.toJSONString(map));

    }
}
