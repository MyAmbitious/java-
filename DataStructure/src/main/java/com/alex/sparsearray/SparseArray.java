package com.alex.sparsearray;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 稀疏矩阵之间相互转换
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //    0 : 表示没有妻子  1表示黑子  2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //   输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        //    将二维数组转稀疏数组
        //先遍历二维数组 得到非0元素的个数
        int sum = 0;
        Map<Map<Integer, Integer>, Integer> map = new ConcurrentHashMap();
        // for (int[] row : chessArr1) {
        //     for (int data : row) {
        //         if(data!=0){
        //             sum++;
        //         }
        //     }
        // }
        for (int a = 0; a < chessArr1.length; a++) {
            for (int b = 0; b < chessArr1[a].length; b++) {
                if (chessArr1[a][b] != 0) {
                    sum++;
                    Map<Integer, Integer> map2 = new ConcurrentHashMap<>();
                    map2.put(a, b);
                    map.put(map2, chessArr1[a][b]);
                }
            }
        }
        int chessArr2[][] = new int[sum + 1][3];
        chessArr2[0][0] = chessArr1.length;
        chessArr2[0][1] = chessArr1[0].length;
        chessArr2[0][2] = sum;

        int i = 1;
        for (Map.Entry<Map<Integer, Integer>, Integer> entry : map.entrySet()) {
            for (Map.Entry<Integer, Integer> entry1 : entry.getKey().entrySet()) {
                chessArr2[i][0] = entry1.getKey();
                chessArr2[i][1] = entry1.getValue();
            }
            chessArr2[i][2] = entry.getValue();
            i++;
        }
        //    打印出稀疏矩阵
        System.out.println("-------------稀疏矩阵---------------");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        System.out.println("-------------原始矩阵---------------");
        int [][]chessArray3 = new int[chessArr2[0][0]][chessArr2[0][1]];
        for(int a=1;a<chessArr2.length;a++){
            chessArray3[chessArr2[a][0]][chessArr2[a][1]] = chessArr2[a][2];
        }
        for (int[] row : chessArray3) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

    }
}
