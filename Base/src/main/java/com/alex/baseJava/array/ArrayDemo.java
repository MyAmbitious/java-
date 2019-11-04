package com.alex.baseJava.array;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = {2,34,35,4,657,8,69,9};
        Arrays.sort(arr);

        String s = Arrays.toString(arr);
        // 打印字符串,输出内容

        System.out.println(s);
        //[2, 34, 35, 4, 657, 8, 69, 9]
    }
}
