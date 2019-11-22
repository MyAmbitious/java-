package com.alex.sorts;

import java.util.Arrays;

/**
 * 插入排序 时间复杂度O(n^2) 空间复杂度O(1) 稳定
 * 算法步骤
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * <p>
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 * （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertSort {
    public static Integer[] sort(Integer[] array) {
        Integer[] arr = Arrays.copyOf(array, array.length);
        for (int i = 1; i < arr.length; i++) {
            //记录要插入的数据值
            Integer temp = arr[i];
            int j = i;
            //设a[0]开始为有序序列，从未排序序列最左边的第一个元素开始比较 找到比其小的数
            //要记得始终使用temp值进行比较 原来的值会发生变化
            while (j > 0 && temp < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                arr[j]=temp;
            }
        }
        return arr;
    }
}
