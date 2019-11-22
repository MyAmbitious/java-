package com.alex.sorts;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        // int [] arr = {-9,78,0,23,-567,70};
        Integer[] arr = {5, 78, 5, 3, 5};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static Integer[] sort(Integer[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    private static void quickSort(Integer[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                //    在pivot的左边一直找，找到大于等于pivot的值才退出循环
                l += 1;
            }
            while (arr[r] > pivot) {
                //    在pivot的右边一直找，找到小于等于pivot的值才退出循环
                r -= 1;
            }
            //    如果l>=r 说明pivot的左右两边的值 已经满足左边的值全部都小于pivot，右边的全部都大于pivot
            if (l >= r) {
                break;
            }
            //    否则就交换
            swap(arr, l, r);
            //    如果交换完后，发现这个arr[1]==pivot值相等 则r-- 前移
            if (arr[l] == pivot) {
               r--;
            }
            //    如果交换完后，发现这个arr[r]==pivot值相等 则l++ 后移
            if (arr[r] == pivot) {
                l++;
            }
        }
        //    如果l==r 必须l++，r-- 否则会出现栈溢出的现象
        if (l == r) {
            l++;
            r--;
        }
           // 向左递归
        if (left < r) {
            quickSort(arr,left,r);
        }
        if (right > l) {
            quickSort(arr,l,right);
        }

    }

    private static void swap(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
