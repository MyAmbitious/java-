package com.alex.baseJava.math;

public class MathDemo {
    public static void main(String[] args) {
        //public static double ceil(double a) ：返回大于等于参数的最小的整数。
        double d1 = Math.ceil(3.3); //d1的值为 4.0
        //public static double floor(double a) ：返回小于等于参数最大的整数。
        double d2 = Math.floor(3.3); //d1的值为3.0
        //public static long round(double a) ：返回最接近参数的 long。(相当于四舍五入方法)
        long d3 = Math.round(5.5); //d1的值为6.0

    }
}
