package com.alex.baseJava.junitDemo;

import org.junit.Test;

public class swap {
    @Test
    public void test1() {
        int a = 45, b = 56;
        swap(a, b);
        System.out.println("a=" + a + ";b=" + b);
    }

    private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = a;
    }
}
