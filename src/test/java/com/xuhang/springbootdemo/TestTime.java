package com.xuhang.springbootdemo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.text.ParseException;

/**
 * @author：xuhang
 * @description：
 * @date：2018/11/8 17:10
 */
public class TestTime {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void test01(){

        redisTemplate.opsForValue().append("msg", "hello");



    }

}
