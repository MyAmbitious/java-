package com.alex.sorts;

import java.util.Arrays;

/**
 * 选择排序 时间复杂度O(n^2) 空间复杂度O(1) 不稳定 相同值的元素可能发生交换
 * 举个例子，序列5 8 5 2 9，我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法。
 * <p>
 * 首先在未排序序列中找到最小（大）元素的位置，存放到排序序列的起始位置（与原始位置进行交换）
 * <p>
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * <p>
 * 重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort {
    public static Integer[] sort(Integer[] array) {
        Integer[] arr = Arrays.copyOf(array, array.length);
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    //找到了此范围内的最小值索引
                    min = j;
                }
            }
            if (min != i) {
                //交换
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
        return arr;
    }
}
