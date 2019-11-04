package com.alex.baseJava.collection;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        //创建 Set集合
        HashSet<String> set = new HashSet<String>();
        // HashMap
        //添加元素
        set.add(new String("cba"));
        set.add("abc");
        set.add("bac");
        set.add("cba");
        //遍历
        for (String name : set) {
            System.out.println(name);
        }
    }
}
