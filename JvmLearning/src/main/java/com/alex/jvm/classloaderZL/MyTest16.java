package com.alex.jvm.classloaderZL;

import java.io.*;

/**
 * 自定义类加载器 加载类
 */
public class MyTest16 extends ClassLoader {
    private String classLoderName;
    private String path;
    private final String fileExtension = ".class";

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16(String classLoderName) {
        super();//将系统类加载器当做该类加载器的父加载器
        this.classLoderName = classLoderName;
    }

    public MyTest16(ClassLoader parnet, String classLoderName) {
        super(parnet);//显示指定该类加载器的父加载器
        this.classLoderName = classLoderName;
    }


    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {

        System.out.println("findClass invocked:" + className);
        System.out.println("class loader name:" + this.classLoderName);
        System.out.println("class name:" + className);

        byte[] data = this.loadClassData(className);

        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        className = className.replace(".", "\\");
        try {

            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int len = 0;
            byte[] b = new byte[1024];
            while (-1 != (len = is.read(b))) {
                baos.write(b, 0, len);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 loder1 = new MyTest16("loader1");
        // loder1.setPath("I:\\idea\\javaBase\\JvmLearning\\target\\classes");
        loder1.setPath("C:\\Users\\Administrator\\Desktop\\");

        //验证类的卸载过程
        loder1 = new MyTest16("loader1");
        loder1.setPath("C:\\Users\\Administrator\\Desktop\\");

        MyTest16 loder2 = new MyTest16(loder1, "loader2");
        loder2.setPath("C:\\Users\\Administrator\\Desktop\\");

        MyTest16 loder3 = new MyTest16("loader3");
        // MyTest16 loder3 = new MyTest16(loder2,"loader3");
        loder3.setPath("C:\\Users\\Administrator\\Desktop\\");
        try {
            test(loder1);

            test(loder1);
            test(loder2);
            test(loder3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test(ClassLoader classLoader) throws Exception {
        // Class<?> clazz = classLoader.loadClass("com.alex.jvm.classloader.MyTest1");
        Class<?> clazz = classLoader.loadClass("com.alex.jvm.classloaderZL.MyTest2");
        System.out.println("class:" + clazz + ":" + clazz.hashCode());
        Object object = clazz.newInstance();
        System.gc();
        // Thread.sleep(100000);
        System.out.println(object);

        System.out.println(object.getClass().getClassLoader());
        //
        // System.out.println("****");
        // classLoader = null;
        // clazz = null;
        // object = null;
        // System.gc();

        System.out.println("-----------------------------------------------------------");

    }


    @Override
    public String toString() {
        return "MyTest16{" +
                "classLoderName='" + classLoderName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                "} ";
    }
}
