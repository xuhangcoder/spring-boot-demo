package com.xuhang.springbootdemo.test;

import com.alibaba.fastjson.JSON;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuhang
 * @date 2020/2/13 16:03
 */
public class TestSplit {
    public static void main(String[] args) {
        String str = "xu:hang";
        String[] split = str.split(":");
        System.out.println(JSON.toJSONString(split));
    }
}
