package com.alex.baseJava.random;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            //3. 随机生成一个数据 左闭右开 不能取到10
            int number = r.nextInt(10);
            //4. 输出数据
            System.out.println("number:"+ number);


        }
        int i=(int)(Math.random()*100);       //  生成0-100的随机数，包括0不包括100 -- [0,100)
        System.out.println(i);
    }
}
