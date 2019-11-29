package com.alex.kmp;

/**
 * 字符串匹配问题：：
 * 有一个字符串 str1= ""硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好""，和一个子串 str2="尚硅谷你尚硅你"
 * 现在要判断 str1 是否含有 str2, 如果存在，就返回第一次出现的位置, 如果没有，则返回-1
 */
public class ViolenceMatch {
    public static void main(String[] args) {
    //测试暴力匹配算法
    /*
    比如str1中的 尚硅谷你尚硅 和str2尚硅谷你尚硅你 直到最后会
     */
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int index = violenceMatch(str1,str2);
        System.out.println("index="+index);
    }

    public static int violenceMatch(String str1, String str2) {
        final char[] s1 = str1.toCharArray();
        final char[] s2 = str2.toCharArray();
        int s1len = s1.length;
        final int s2len = s2.length;
        int i = 0;
        int j = 0;
        while (i < s1len && j < s2len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                //    没有匹配成功
                i = i - j + 1;
                j = 0;
            }
        }
        //判断是否匹配成功
        if (j == s2len) {
            return i-j;
        } else {
            return -1;
        }
    }
}
