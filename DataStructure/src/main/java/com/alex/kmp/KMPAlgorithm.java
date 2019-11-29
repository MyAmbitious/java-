package com.alex.kmp;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        final int[] next = kmpNext(str2);
         System.out.println("next=" + Arrays.toString(next));
        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index);
    }


    //kmp搜索算法

    /**
     * @param str1 源字符串
     * @param str2 要匹配的字串
     * @param next 字串对应的部分匹配表
     * @return 如果是-1就是没有匹配到 否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        //遍历
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //处理str1.charAt(j) != str2.charAt(j)的情况 去调整J的大小
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                //找到了
                return i - j + 1;
            }
        }
        return -1;
    }

    //    获取到一个字符串的部分匹配值
    public static int[] kmpNext(String dest) {
        //创建一个next数组 保存部分匹配值
        int[] next = new int[dest.length()];
        //    如果字符串的长度是1 部分匹配值就是0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //   当dest.charAt(i) != dest.charAt(j)不相等的时候
            //从next[j-1]中获得新的J 这是KMP算法的核心
            //核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //    当dest.charAt(i) == dest.charAt(j) 满足是 部分匹配值就+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
