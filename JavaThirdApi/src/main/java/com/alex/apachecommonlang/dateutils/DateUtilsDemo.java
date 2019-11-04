package com.alex.apachecommonlang.dateutils;


import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class DateUtilsDemo {
    public static void main(String[] args) {
        final Date date = DateUtils.addWeeks(new Date(), 1);
        System.out.println(date);

    }
}
