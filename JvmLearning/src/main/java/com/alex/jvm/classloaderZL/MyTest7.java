package com.alex.jvm.classloaderZL;

public class MyTest7 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            System.out.println(clazz.getClassLoader());
            Class<?> clazz2 = Class.forName("com.alex.jvm.classloaderZL.D");
            System.out.println(clazz2.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class D{

}