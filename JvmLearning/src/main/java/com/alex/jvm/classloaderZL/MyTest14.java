package com.alex.jvm.classloaderZL;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        /**
         * The context ClassLoader of the
         *       primordial thread is typically set to the class loader used to load the
         *      * application.
         *    contextClassLoader通常被设置为用于加载应用的加载器
         */
        String resourceName = "com\\alex\\jvm\\classloader\\MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()){
            final URL url = urls.nextElement();
            System.out.println(url);
        }
        System.out.println("---------------");
        final Class<MyTest14> clazz = MyTest14.class;
        System.out.println(clazz.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("------------");
        final Class<?> clazz1 = String.class;
        System.out.println(clazz1.getClassLoader());//null

    }
}
