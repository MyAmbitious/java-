package com.alex.sorts;

import java.util.Arrays;

/**
 * 冒泡排序 时间复杂度O(n^2)  空间复杂度O(1) 稳定
 *  算法步骤
 *
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 *
 * 针对所有的元素重复以上的步骤，除了最后一个。
 *
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 */
public class BubbleSort {
    public static Integer[] sort(Integer[] array) {
        Integer[] arr = Arrays.copyOf(array, array.length);

        //i控制内层j循环比较交换的轮次数量
        for (int i = 1; i < arr.length; i++) {
            //每轮内层循环结束后 则会将其最大的数字放在最后的位置,下一次循环的时候就不需要考虑此位置。构成形似冒泡 故称之为冒泡算法

            // 设定一个标记，若为true，则表示此次内循环没有进行交换，也就是待排序列已经有序，排序已经完成,直接退出循环。
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}
