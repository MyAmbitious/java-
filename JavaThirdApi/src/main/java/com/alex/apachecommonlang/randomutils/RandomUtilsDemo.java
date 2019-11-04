package com.alex.apachecommonlang.randomutils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RandomUtilsDemo {
    public static void main(String[] args) {
        final int i = RandomUtils.nextInt(45, 47);
        System.out.println(i);
        final String s = RandomStringUtils.randomNumeric(4);
        System.out.println(s);
    }
}
