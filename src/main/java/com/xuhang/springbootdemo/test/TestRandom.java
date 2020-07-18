package com.xuhang.springbootdemo.test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author xuhang
 * @date 2019/8/13 10:38
 */
public class TestRandom {


    public static void main(String[] args) {
        double max = 494.50;
        double min = 493.50;
        Random random = new Random();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 2500; i++) {
            double str = min + ((max - min) * random.nextDouble());
            String rate = formateRate(String.valueOf(str));

            String lastNumber = rate.substring(rate.length() - 1, rate.length());
            if ((Integer.parseInt(lastNumber)%2)==0){
                list.add(rate);
            }
        }
        System.out.println(list);
        System.out.println("size为："+list.size());


    }
    public static String formateRate(String rateStr) {
        if (rateStr.indexOf(".") != -1) {
            // 获取小数点的位置
            int num = 0;
            num = rateStr.indexOf(".");

            String dianAfter = rateStr.substring(0, num + 1);
            String afterData = rateStr.replace(dianAfter, "");

            return rateStr.substring(0, num) + "." + afterData.substring(0, 2);
        } else {
            if (rateStr == "1") {
                return "100";
            } else {
                return rateStr;
            }
        }
    }

}
