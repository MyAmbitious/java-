package com.alex.baseJava.string;

public class IntegerToString {
    public static void main(String[] args) {
        int i = 4;
        String i1 = "" + i;                 //String i1 = (new StringBuilder()).append(i).toString();
        String i2 = String.valueOf(i);      // public static String valueOf(int i)
        String i3 = Integer.toString(i);    // public static String toString(int i)


        //String.valueOf(Object obj)可以把整型（包括0）转化为字符串，但是Integer如果是null的话，会转化为”null”。
        // 从String.valueOf(Object obj)方法的源码可以看出：
        /**
         *  public static String valueOf(Object obj) {
         *         return (obj == null) ? "null" : obj.toString();
         *     }
         */
        Integer b = null;
        Object o = null;
        System.out.println(String.valueOf(o));
        System.out.println(String.valueOf(false));
        System.out.println(String.valueOf(b));


        //通过toString()方法，可以把整数（包括0）转化为字符串，但是Integer如果是null的话，就会报空指针异常。
        System.out.println(b.toString());


        /**
         *
         * int 或者 integer对象转成string有三种上面方法
         * 第3行和第4行没有任何区别，因为String.valueOf(i)也是调用Integer.toString(i)来实现的。
         *
         * String.valueOf(i)源码如下
         *      public static String valueOf(int i) {
         *         return Integer.toString(i);
         *     }
         *
         * 第2行代码会产生两个String对象
         * 其实是String i1 = (new StringBuilder()).append(i).toString();，首先创建一个StringBuilder对象，然后再调用append方法，再调用toString方法。(可以通过反编译查看)
         */
    }
}
