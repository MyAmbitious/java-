package com.alex.doc;

public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        //    如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //    如果我们有n>=2的情况 我们总是将其看做有两个盘 盘1：最下面的盘  盘2：上面的所有盘
            //    把最上面的所有盘从A->B  移动过程使用到C塔
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //    把B塔的所有盘从B->C  移动过程使用到a塔
            hanoiTower(num - 1, b, a, c);
        }
    }
}
