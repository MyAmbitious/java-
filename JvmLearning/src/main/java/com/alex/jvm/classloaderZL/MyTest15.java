package com.alex.jvm.classloaderZL;

/**
 *  The class loader for an array class, as returned by Class.getClassLoader() is the same as the class loader for its element type;
 *  if the element type is a primitive type, then the array class has no class loader.
 * Applications implement subclasses of ClassLoader in order to extend the manner
 */
public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());//null String类的类加载器 根加载器 表示为null
        System.out.println("-------------------");

        MyTest15 [] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2

        System.out.println("--------------");
        int [] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader()); //null  primitive type的类加载器 则此数组的 class对象没有类加载器
    }
}
