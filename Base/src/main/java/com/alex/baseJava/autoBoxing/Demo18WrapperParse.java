package com.alex.baseJava.autoBoxing;
//一个基本数据类型转为String类型，一般有三种方式，
// 例如：有一个Integer型数据a，可以使用i.toString()、String.valueOf(i)、i+””三种方式，
public class Demo18WrapperParse {
    public static void main(String[] args) {
        Integer b = Integer.valueOf(450);
        String b1 = String.valueOf(b);
        String b2 = b.toString();
        String b3 = b+"";

        // int num = Integer.parseInt("100");
        // System.out.println(num);
        System.out.println(b1.equals(b2));
    }
}
