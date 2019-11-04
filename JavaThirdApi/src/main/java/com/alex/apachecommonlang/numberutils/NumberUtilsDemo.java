package com.alex.apachecommonlang.numberutils;

import org.apache.commons.lang3.math.NumberUtils;

public class NumberUtilsDemo {
    public static void main(String[] args) {
        final int compare = NumberUtils.compare(4, 3);
        System.out.println(compare);
    }
}
