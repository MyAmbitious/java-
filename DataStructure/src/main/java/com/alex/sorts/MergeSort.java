package com.alex.sorts;

import java.util.Arrays;

public class MergeSort {
    public static int count = 0;

    public static void main(String[] args) {
        // Integer [] arr = {-9,78,0,23,-567,70};
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        // System.out.println(Arrays.toString(arr));
        // mergeSort(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1, new Integer[arr.length]);
        System.out.println("归并排序后" + Arrays.toString(arr));
    }

    //调用函数
    public static Integer[] sort(Integer[] arr) {
        mergeSort(arr, 0, arr.length - 1, new Integer[arr.length]);
        return arr;
    }

    //分解+合并
    public static void mergeSort(Integer[] arr, Integer left, Integer right, Integer[] temp) {
        if (left < right) {
            Integer mid = (left + right) / 2; //中间索引
            //    向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);

            //    分解完毕后 合并两段有序序列(第一次合并是左右都只有一个元素)
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @param arr     待排序的原始数组
     * @param left    左边有序序列的初始索引
     * @param leftEnd 左边有序序列的结束索引
     * @param right   右边有序序列的结束索引
     * @param temp    中转的数组
     */
    public static void merge(Integer[] arr, Integer left, Integer leftEnd, Integer right, Integer[] temp) {
        count++;
        Integer i = left; //初始化i 左边有序序列的初始索引
        Integer j = leftEnd + 1; // 初始化j,右边有序序列的初始索引
        Integer t = 0;//指向temp数组的当前索引

        //先把左右两边有序的数据安装规则填充到temp数组
        //直到左右两边的有序序列有一边处理完毕为止
        while (i <= leftEnd && j <= right) {
            //如果左边的有序序列的当前元素 小于等于右边有序序列的当前元素 就将左边序列i指向的当前元素 填充到temp数组
            //然后t++,i++
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        // 把有剩余元素的一边的数据依次全部填充到temp数组中
        while (i <= leftEnd) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //    将temp数组的元素拷贝到原数组arr中
        t = 0;
        Integer tempLeft = left;
        System.out.println("tempLeft=" + tempLeft + " right=" + right);
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
}
