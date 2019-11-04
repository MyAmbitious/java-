package com.alex.baseJava.calendar;

import java.util.Calendar;

public class CalendarUtil {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);

        // // 创建Calendar对象
        // Calendar cal = Calendar.getInstance();
        // // 设置年
        int year = cal.get(Calendar.YEAR);
        // // 设置月
        int month = cal.get(Calendar.MONTH) + 1;
        // // 设置日
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "年" + month + "月" + dayOfMonth + "日");

        // 使用add方法
        cal.add(Calendar.DAY_OF_MONTH, 2); // 加2天
        cal.add(Calendar.YEAR, -3); // 减3年

        year = cal.get(Calendar.YEAR);
        // // 设置月
        month = cal.get(Calendar.MONTH) + 1;
        // // 设置日
        dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "年" + month + "月" + dayOfMonth + "日"); // 2015年1月18日;
        System.out.println(cal.getTime());
    }
}
