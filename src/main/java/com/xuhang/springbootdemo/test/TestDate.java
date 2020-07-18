package com.xuhang.springbootdemo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xuhang
 * @date 2019/11/20 10:19
 */
public class TestDate {
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        min = null;max = null;curr = null;
        return result;
    }

    public static void main(String[] args) throws ParseException {
        String minDate = "2018-01-01";
        String maxDate = "2018-06-12";
        List<String> list = getMonthBetween(minDate, maxDate);
        for(String s : list){
            System.out.println(s);
        }

    }
}
