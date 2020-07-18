package com.xuhang.springbootdemo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import com.xuhang.springbootdemo.dto.JsonParseDTO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhang
 * @date 2019/8/12 16:11
 */
public class JsonParseTest {
    public static void main(String[] args) throws FileNotFoundException {

        JSONReader reader = new JSONReader(new FileReader("org.json"));
        reader.startArray();
        ArrayList<String> list = new ArrayList<>();
        while (reader.hasNext()) {
            JsonParseDTO jsonParseDTO = reader.readObject(JsonParseDTO.class);
            list.add(jsonParseDTO.getCode());
        }
        reader.endArray();
        reader.close();
        System.out.println(list);

    }
}
