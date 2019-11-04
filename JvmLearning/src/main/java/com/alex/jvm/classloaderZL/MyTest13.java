package com.alex.jvm.classloaderZL;

public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (classLoader != null) {
            /**
             * Some implementations may
             *  use <tt>null</tt> to represent the bootstrap class loader.
             */
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }

    }
}
