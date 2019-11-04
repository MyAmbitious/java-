package com.alex.jvm.classloaderZL;
class Parent2 {
    static int a = 3;
    static {
        System.out.println("parent2 static block");
    }
}
class Child2 extends Parent2{
    static int b = 45;
    static {
        System.out.println("child2 static block");
    }
}
public class MyTest10 {
    static {
        System.out.println("MyTest10 static block");
    }
    {
        System.out.println("MyTest10 nostatic block");
    }
    public static void main(String[] args) {
        Parent2 parent2;
        System.out.println("-------------------");
        parent2 = new Parent2();
        System.out.println("-----------------------");
        System.out.println(parent2.a);
        System.out.println("---------------------");
        System.out.println(Child2.b);
        /**
         * 结果如下
         * MyTest10 static block
         * -------------------
         * parent2 static block
         * -----------------------
         * 3
         * ---------------------
         * child2 static block
         * 45
         */
    }
}
