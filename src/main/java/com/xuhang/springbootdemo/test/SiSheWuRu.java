package com.xuhang.springbootdemo.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author xuhang
 * @date 2019/5/20 14:59
 */
public class SiSheWuRu {

    public static void main(String[] args) {
        BigDecimal before = new BigDecimal("11.145");
        BigDecimal after = before.setScale(2, RoundingMode.HALF_UP);
        System.out.println("四舍五入后：" + after);


    }
}
