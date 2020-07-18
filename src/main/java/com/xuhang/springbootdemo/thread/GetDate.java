package com.xuhang.springbootdemo.thread;

import java.util.Date;

/**
 * @author：xuhang
 * @description：获取未来几天的日期
 * @date：2018/11/1 9:53
 */
public class GetDate {

    public static Date getNextDays(int days){
        try {
            // 休眠指定的天数
            Thread.sleep(days * 24 * 60 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 休眠结束后返回日期
        return new Date();
    }
}
