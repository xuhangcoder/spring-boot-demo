package com.xuhang.springbootdemo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xuhang
 * @date 2019/7/9 11:12
 */
public class TestDateDiff {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date beginTime = format.parse("2019-07-14 13:40");
        Date endTime = format.parse("2019-07-14 14:30");
        int diff = new TestDateDiff().diff(beginTime, endTime);
        System.out.println(diff);

    }

    private int diff(Date beginTime,Date endTime){

        Calendar instance = Calendar.getInstance();
        //获取开始的时间和分钟数
        instance.setTime(beginTime);
        int beginHour = instance.get(Calendar.HOUR_OF_DAY);
        int beginMin = instance.get(Calendar.MINUTE);

        instance.set(Calendar.HOUR_OF_DAY,12);
        instance.set(Calendar.MINUTE,30);
        Date noonBegin = instance.getTime();
        //获取结束的时分数
        instance.setTime(endTime);
        int endHour = instance.get(Calendar.HOUR_OF_DAY);
        int endMin = instance.get(Calendar.MINUTE);
        instance.set(Calendar.HOUR_OF_DAY,13);
        instance.set(Calendar.MINUTE,30);
        Date noonEnd = instance.getTime();
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));
        long lastMs = endTime.getTime() - beginTime.getTime();
        //进行中午一小时时间的判断去除

        if (!beginTime.before(noonBegin) && beginTime.before(noonEnd)){
            lastMs = lastMs - (((13 - beginHour) * 60 + (30 - beginMin))*60000);
            if (lastMs == 0) {return 0;}
        }
        if (endTime.after(noonBegin) && !endTime.after(noonEnd)){
            lastMs = lastMs - (((endHour - 12)*60 + (endMin - 30))*60000);
            if (lastMs == 0) {return 0;}
        }
        if (beginTime.before(noonBegin) && endTime.after(noonEnd)){
            lastMs = lastMs - 3600000;
        }

        //将毫秒换算为分钟
        int lastTime =(int) (lastMs / 60000);
        return lastTime;
    }
}
