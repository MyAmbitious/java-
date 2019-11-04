package com.alex.jvm.classloaderZL;

class Parent {
    static int a = 3;
    static {
        System.out.println("parent static block");
    }
}
class Child extends Parent{
    static int b = 3;
    static {
        System.out.println("child static block");
    }
}
public class MyTest9 {
    static {
        System.out.println("MyTest9 static block");
    }
    {
        System.out.println("MyTest9 nostatic block");
    }
    public static void main(String[] args) {
        System.out.println(Child.b);
        /**
         * 结果如下
         * MyTest9 static block
         * parent static block
         * child static block
         * 3
         */
    }
}
