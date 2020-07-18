package com.xuhang.springbootdemo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xuhang
 * @date 2019/3/12 9:38
 */
public class Person {

        public Person(String name) {
            this.name = name;
        }
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    public static void main(String[] args) throws ParseException {

//        String start = "2019-03-13 14:00";
//        String end = "2019-03-15 15:00";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Date startDate = sdf.parse(start);
//        Date endDate = sdf.parse(end);
//
//        Calendar calendar = Calendar.getInstance();
//                       calendar.setTime(startDate);
//                        int cnt = 0;
//                        while(calendar.getTime().compareTo(endDate)!=0){
//                                calendar.add(Calendar.DATE, 1);
//                                 cnt++;
//                             }
////        System.out.println(cnt);
//        SimpleDateFormat sdf =  new SimpleDateFormat("yyyyMMdd");
//
//        Date s =    sdf.parse("00000000");
//        sdf.format(s);
//        System.out.println(sdf.format(s));

        String s = "0000000001000000000";
        String s1 = s.replaceFirst("^0*", "");
        System.out.println(s1);

    }
}
