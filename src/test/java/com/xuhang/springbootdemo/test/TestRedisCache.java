package com.xuhang.springbootdemo.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author xuhang
 * @date 2018/12/21 14:57
 */
public class TestRedisCache {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public  void test001(){

        stringRedisTemplate.opsForValue().append("msg","xuhang");


    }
}
