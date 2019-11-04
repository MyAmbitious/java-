package com.alex.baseJava.objects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo02SimpleDateFormat {
    public static void main(String[] args) {
        //format方法 把Date对象转换成String
        Date date = new Date();
        // 对应的日期格式如：2019-10-13 20:49:15
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String str = format.format(date);
        System.out.println(str); // 2008年1月23日


        // /*
        //  parse方法把String转换成Date对象
        // */
        String str1 = "2018年12月11日";
        try {
            Date date1 = df.parse(str1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date); // Tue Dec 11 00:00:00 CST 2018
    }
}
