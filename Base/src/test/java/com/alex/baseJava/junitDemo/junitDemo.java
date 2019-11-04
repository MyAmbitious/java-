package com.alex.baseJava.junitDemo;

import org.junit.Test;

import java.util.ArrayList;

public class junitDemo {
    @Test
    public void test1(){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(45);
        System.out.println(a.get(0));
    }
}
