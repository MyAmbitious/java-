package com.alex.jvm.classloaderZL;
class Parent3 {
    static int a = 3;
    static {
        System.out.println("parent3 static block");
}
    public  static void  dosomething(){
        System.out.println("dosomething");
    }
}
class Child3 extends Parent3{
    static int b = 45;
    static {
        System.out.println("child3 static block");
    }

}
public class MyTest11 {
    public static void main(String[] args) {

        //如果用子类去访问其父类中的静态变量和静态方法 都是对父类的主动使用 而不是对子类的主动使用 因此会导致父类初始化而子类不会初始化
        System.out.println(Child3.a);
        Child3.dosomething();
        /**
         * 打印结果
         * parent3 static block
         * 3
         * dosomething
         */
    }
}
