package com.xuhang.springbootdemo.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author xuhang
 * @date 2018/12/3 16:59
 */
@Data
public class User {
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private String age;
    /**
     * 创建时间
     */
    private Date createTime;

    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        if (a && b) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

}
