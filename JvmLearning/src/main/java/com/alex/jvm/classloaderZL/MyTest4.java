package com.alex.jvm.classloaderZL;

/**
 * 对于数组实例来说 其类型是由JVM在运行期间动态生成的 而不是类加载器加载的 表示为class [Lcom.alex.jvm.classloader.MyParent4 这种形式
 * 动态生成的类型 其父类型就是Object
 * 对于数组来说：JavaDoc经常将构成数组的元素称为Component，实际上就是将数组降低一个维度的类型
 *
 *助记符：
 * anewarray：表示创建一个引用类型（如类，接口,数组）的数组，并将其引用值压入栈顶
 * newarray ：表示创建一个指定的运势类型 （如int,float,char等）的数组 并将其引用值压入栈顶
 */
public class MyTest4 {
    public static void main(String[] args) {
        // MyParent4 myParent4 = new MyParent4();//创建类的实例 首次主动使用 静态代码块会执行 打印出MyParent4 static code
        MyParent4[] myParent4 = new MyParent4[1];//静态代码块会执行 说明这行代码并不是首次对类的首次使用 并没有初始化类
        System.out.println(myParent4.getClass());//class [Lcom.alex.jvm.classloader.MyParent4; jvm在运行的时候帮助我们创建出来的
        MyParent4[][] myParent41 = new MyParent4[1][1];
        System.out.println(myParent41.getClass()); //class [[Lcom.alex.jvm.classloader.MyParent4;
        System.out.println(myParent41.getClass().getSuperclass()); //class java.lang.Object
        System.out.println("===========");

        int [] ints = new int[1];
        System.out.println(ints.getClass());//class [I
        System.out.println(ints.getClass().getSuperclass());//class java.lang.Object
        System.out.println("===========");
        char[] chars = new char[2];
        System.out.println(chars.getClass());
        boolean[] b =new boolean[1];
        System.out.println(b.getClass());
        short[] shorts = new short[1];
        System.out.println(shorts.getClass());
        Integer[] integers =new Integer[1];
        System.out.println(integers.getClass());
    }
}

class MyParent4 {

    static {
        System.out.println("MyParent4 static code");
    }
}
