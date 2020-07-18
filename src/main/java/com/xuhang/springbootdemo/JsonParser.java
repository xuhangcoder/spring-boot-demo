package com.xuhang.springbootdemo;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * @author xuhang
 * @date 2019/5/15 14:25
 */
public class JsonParser {


    public static void main(String[] args) {
        String json = "{openid = ershuai222,session_key = ershuai11}";
        Gson gson = new Gson();
        HashMap<String, Object> map = new HashMap<>();
        map = gson.fromJson(json, map.getClass());
        System.out.println(map.get("openid"));

    }
}
