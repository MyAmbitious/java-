package com.alex.baseJava.scanner;

import java.util.Scanner;



public class ScannerTest {
    int age = 10;
    public static void main(String[] args) {
        //ArrayList对象不能存储基本类型，只能存储引用类型的数据。类似 <int> 不能写，但是存储基本数据类型对应的 包装类型是可以的
        // 普通方式
        Scanner sc = new Scanner(System.in);
        int a = new Scanner(System.in).nextInt();
        input(sc);

        //匿名对象作为方法接收的参数 input(new Scanner(System.in));
    }

    public static void input(Scanner sc){ System.out.println(sc); }
}
