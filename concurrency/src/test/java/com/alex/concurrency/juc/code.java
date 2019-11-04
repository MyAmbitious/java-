package com.alex.concurrency.juc;

import org.junit.Test;

import java.util.*;

public class code {
    public static void main(String[] args) {
        int a, b, c, min, max, k=0;
        List<Integer> s = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        s.add(c);
        s.add(b);
        s.add(a);

        Collections.sort(s);
        max = s.get(s.size() - 1);
        min = s.get(0);
        for (int i = min; i > 0; i--) {
            if (min % i == 0 && max % i == 0) {
                k = i;
            }
        }
        System.out.println(min/k+"/"+max/k);
    }

    @Test
    public void test() {

        // 获取随机数
        Random r = new Random();

        // 创建集合对象
        HashSet<Integer> set = new HashSet<>();

        // 生成随机数
        while (set.size() < 10) {
            set.add(r.nextInt(20) + 1);
        }

        // 遍历集合
        for (int integer : set) {
            System.out.println(integer);
        }
    }

    @Test
    public void test1() {

        // 获取随机数
        Random r = new Random();

        // 创建集合对象
        HashSet<Integer> set = new HashSet<>();

        // 生成随机数
        while (set.size() < 13) {
            System.out.println(set.size());
            set.add(r.nextInt(20) + 1);
            System.out.println(set);
        }

        // 遍历集合
        for (int integer : set) {
            System.out.println(integer);
        }
    }


}
