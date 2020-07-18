package com.xuhang.springbootdemo.test;

/**
 * @author xuhang
 * @date 2019/6/13 10:58
 */
public class Sleep {
    public Object getObject() {
        Object object = new Object();

        /**
         * 查询代码
         */

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return object;
    }
}
