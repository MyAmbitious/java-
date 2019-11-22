package com.alex.search;

import java.util.ArrayList;

//使用二分查找的前提是 该数组是有序的
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {3, 12, 15, 56, 71, 71, 71, 71, 72, 84};

        // final int i = Arrays.binarySearch(arr, 12);
        // System.out.println("12所在的下标位置是" + i);

        // final int i = binarySearch(arr, 0, arr.length - 1, 71);
        final ArrayList<Integer> integers = binarySearch2(arr, 0, arr.length - 1, 710);
        System.out.println("目标值的下标位置是" + integers.toString());
    }



    public static int binarySearch3(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (left > right) {
            return -1;
        }
        if (findVal > midVal) {//向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {//向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }


    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (left > right) {
            return new ArrayList<Integer>();
        }
        if (findVal > midVal) {//向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {//向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
             /*
              当一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到
              思路 返回一个ArrayList 找到mid的索引值后 不要马上返回
              向mid索引值的左右边扫描 将所有满足findVal的下标 加入到集合ArrayList中
             */

            ArrayList<Integer> resIndexList = new ArrayList<>();
            //    向mid索引值得左边扫描
            int temp = mid - 1;
            while (temp > 0 && arr[temp] == findVal) {
                resIndexList.add(temp--);
            }
            resIndexList.add(mid);
            temp = mid + 1;
            while (temp < right && arr[temp] == findVal) {
                resIndexList.add(temp++);
            }
            return resIndexList;
        }
    }


    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (left > right) {
            return -1;
        }
        if (findVal > midVal) {//向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {//向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    public static int binarySearch1(int[] arr, int left, int right, int findVal) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > findVal) {
                right = mid - 1;
            } else if (arr[mid] < findVal) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
