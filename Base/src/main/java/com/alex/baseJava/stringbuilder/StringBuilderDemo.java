package com.alex.baseJava.stringbuilder;


//它的内部拥有一个数组用来存放字符串内容，进行字符串拼接时，直接在数组中加入新内容。
// StringBuilder会自动维护数组的扩容。原理如下图所示：(默认16字符空间，超过自动扩充)
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        System.out.println(sb1); // (空白)
        // 使用带参构造
        StringBuilder sb2 = new StringBuilder("itcast");
        sb2.append("das");
        System.out.println(sb2.toString()); // itcast
    }
}
