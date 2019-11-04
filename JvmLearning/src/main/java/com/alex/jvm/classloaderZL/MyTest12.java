package com.alex.jvm.classloaderZL;

class CL {
    static {
        System.out.println("Class CL");
    }
}

public class MyTest12 {
    public static void main(String[] a) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            Class<?> clazz = loader.loadClass("com.alex.jvm.classloaderZL.CL");
            System.out.println(clazz);
            System.out.println("-----------------");
            //Class.forName 反射 属于对类的主动使用 导致类的初始化
            //而调用classLoader类的loadClass方法加载一个类，并不是对类的主动使用
            clazz = Class.forName("com.alex.jvm.classloaderZL.CL");
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
