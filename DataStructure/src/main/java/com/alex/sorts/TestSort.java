package com.alex.sorts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestSort {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random rand = new Random();
        // for (int i = 0; i <8000000; i++) {
        //     list.add(rand.nextInt(8000000)+1);
        // }
        for (int i = 0; i < 100; i++) {
            list.add(rand.nextInt(100) + 1);
        }
        Integer[] array = list.toArray(new Integer[list.size()]);

        // final Integer[] sortArray = BubbleSort.sort(array);
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final long start = System.currentTimeMillis();
        System.out.println("排序前" + simpleDateFormat.format(new Date()));
        // final Integer[] sortArray = InsertSort.sort(array);
        // final Integer[] sortArray = SelectionSort.sort(array);
        // final Integer[] sortArray = ShellSort.sort(array);
        // final Integer[] sortArray = QuickSort.sort(array);
        final Integer[] sortArray = MergeSort.sort(array);
        System.out.println("归并排序共发生了" + MergeSort.count + "次合并");
        System.out.println("排序后" + simpleDateFormat.format(new Date()));
        System.out.println("排序花费时间为" + (System.currentTimeMillis() - start) + "ms");
        print(sortArray);

    }

    private static void print(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d \t", array[i]);
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

}
