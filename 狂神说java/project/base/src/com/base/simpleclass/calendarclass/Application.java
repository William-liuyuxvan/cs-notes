package com.base.simpleclass.calendarclass;

import java.util.Calendar;

/**
 * @ClassName Application
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/28 15:20
 */
public class Application {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime().toLocaleString());

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY); // HOUR是12小时 HOUR_OF_DAY是24小时
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.println(year + "年" + (month+1) + "月" + day + "日 " + hour + ":" + minute + ":" + second);
    }
}
