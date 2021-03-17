package com.xuhang.springbootdemo.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author xuhang
 * @date 2020/5/7 15:01
 */
//@Component
public class TestRedis {
    @Autowired
    StringRedisTemplate stringredisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void  testRedis() {

        stringredisTemplate.opsForValue().set("hello", "china");

        System.out.println(stringredisTemplate.opsForValue().get("hello"));

        User user = new User();
        user.setName("xuhang");
        user.setSex("男");
        user.setAge("25");

        Jackson2HashMapper mapper = new Jackson2HashMapper(objectMapper, false);
        stringredisTemplate.opsForHash().putAll("xuhang01", mapper.toHash(user));

        Map map = stringredisTemplate.opsForHash().entries("xuhang01");

        User value = objectMapper.convertValue(map, User.class);
        System.out.println(value.getName());
    }
    }

