package com.alex.concurrency.juc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestAtomic {
    @Test
    public void atomic() {
        int i = 10;
        i = i++;
        System.out.println(i); //10
    }

    @Test
    public void juc() {
        Hashtable h = new Hashtable();
        Map m = new HashMap();
        Map m1 = new ConcurrentHashMap();
        int i = 10;
        i = i++;
        System.out.println(i); //10
    }
}
