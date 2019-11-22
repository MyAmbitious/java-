package com.alex.search;

import java.util.Arrays;

public class FibonacciSearch {
    private static int maxsize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        final int i = fibSearch(arr, 10);
        System.out.println(i);
    }

    //    构造一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxsize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxsize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //    编写斐波那契数列查找算法

    /**
     * @param a   数组
     * @param key 我们需要查找的关键码（值）
     * @return 返回对应的下标  如果没有则返回-1
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;//存放mid值
        int f[] = fib();
        //获取到斐波那契数列分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //
        final int[] temp = Arrays.copyOf(a, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        //    使用while来循环处理 找到我们的数key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;//表示没有找到
    }
}
