package com.alex.baseJava.string;

import java.io.UnsupportedEncodingException;

//类似ab这样的直接双引号赋值的字符串对象 是在字符串常量池里面的，所以两者地址值一样
//但是c这样的是new出来的，不在常量池里面 故跟ab地址值不一样
//常量池存储在堆中 存放的是一个个byte数组的地址值
public class StringDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println(a==b);
        System.out.println(c==b);
        System.out.println(a==c);
        System.out.println(a.equals(c));
        // int a = 45;
        // int b = 45;
        // int c =Integer.valueOf(45);
        // System.out.println(a==b);
        // System.out.println(c==b);
        // System.out.println(a==c);
        // System.out.println(a.getBytes("UTF-8"));
    }
}
