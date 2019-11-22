package com.alex.sorts;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }


    //基数排序方法
    public static void radixSort(int[] arr) {
        //先得到数组中最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLenth = (max + "").length();
        //    定义一个二维数组 表示10个桶 每个桶就是一个一维数组
        //    说明
        //    1 二维数组包含10个一维数组
        //    2 为了防止在放入数的时候 数据溢出 则每个一维数组（桶）,大小应定为arr.length
        //    基数排序是很明显的空间换时间的算法

        int[][] bucket = new int[10][arr.length];

        //    为了理解每个桶中 实际上存放了多少个数据 我们定义一个一维数组来记录各个桶的每次放入数据的个数
        //    比如:bucketElementCounts[0] 记录的就是bucket[0]桶的放入数据个数
        int[] bucketElementCounts = new int[10];
        for (int m = 0, n = 1; m < maxLenth; m++, n *= 10) {
            //第一轮 对每个待排元素的个位数进行排序处理
            for (int j = 0; j < arr.length; j++) {
                //    取出每个元素对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                //一开始是向 bucket[digitOfElement][0]的地方存放数据 后来在digitOfElement相同的情况下 会向bucket[digitOfElement][1]  bucket[digitOfElement][2]存放数据
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                //比如:bucketElementCounts[0] 记录的就是bucket[0]桶的放入数据个数 放入一个后数量加1
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入到原来的数组中）
            int index = 0;
            //遍历每一个桶 并且将桶中的数据 放入到原数组中
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //    如果桶中有数据 我们才放入到原数组中
                if (bucketElementCounts[k] != 0) {
                    //    循环该桶 既第k个一维数组 放入
                    for (int i = 0; i < bucketElementCounts[k]; i++) {
                        //    取出元素放入到arr
                        arr[index++] = bucket[k][i];
                    }
                }
                //    第i+1轮处理后 需要将每个bucketElementCounts[k]置为0
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + (m + 1) + "轮对个位数排序之后的结果是：" + Arrays.toString(arr));
        }
    }
}
