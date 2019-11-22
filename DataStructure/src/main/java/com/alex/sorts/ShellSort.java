package com.alex.sorts;

import java.util.Arrays;

public class ShellSort {
    public static Integer[] sort(Integer[] array) {
        Integer[] arr = Arrays.copyOf(array, array.length);
        int gap = 1;
        //gap为步长 原数组从下标0开始 以gap为步长分组 然后对每组内进行插入排序
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }
        while (gap>0){
        //    分为多组 每组进行插入排序
            for(int i=gap;i<arr.length;i++){
                int temp = arr[i];//记录此组内的最后一个元素
                int j = i-gap;
                while (j>=0&& temp<arr[j]){
                     arr[j+gap]=arr[j];
                     j-=gap;
                }
                arr[j+gap] =temp;
            }
            //每次组内排序完成后 将原来的步长变为原来的三分之一 最后一次gap=1 既对数组进行一次全部的插入排序
            gap = (int)Math.floor(gap/3);

        }
        return arr;
    }
}
