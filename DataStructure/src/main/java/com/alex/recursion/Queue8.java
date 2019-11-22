package com.alex.recursion;

public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果 比如arr[8] = {0,4,7,5...} 第一个皇后放在棋盘第一行的第一列 第二个皇后放在第二行的第五列。。。。。以此类推
    //理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题. arr[8] = {0 , 4, 7, 5, 2, 6, 1, 3}
    // 对应arr 下标 表示第几行，即第几个皇后，arr[i] = val , val 表示第i+1个皇后，放在第i+1行的第val+1列
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        //测试一把 8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法",count);//92
    }

    //开始放置第n个皇后的方法
    //check每一次递归的时候 都有一个循环 产生回溯
    private void check(int n) {
        if (n == max) {//n=8,其实8个皇后此时已经都被放好了 直接打印 退出方法
            print();
            return;
        }
        //    依次放入皇后 并判断是否发生冲突
        for (int i = 0; i < max; i++) {
            //先把这个皇后放在该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时 是否发生冲突
            if (judge(n)) {//不冲突的情况下
                //则继续放第n+1个皇后，既开始递归
                check(n + 1);//会产生回溯
            }
            //    如果发生冲突 就继续执行array[n]=i;即将第n个皇后 放置在本行后移的一个位置
        }
    }

    //查看当我们放置第n个皇后是 就去检该皇后是否和前面已经拜访的皇后发生冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //如果在同一行或者对角线上 返回false
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //    写一个方法 可以将皇后拜访的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println();
    }
}
