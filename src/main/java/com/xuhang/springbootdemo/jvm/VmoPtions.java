package com.xuhang.springbootdemo.jvm;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xuhang
 * @date 2020/3/9 11:01
 */
public class VmoPtions {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        super.finalize();
    }
}
