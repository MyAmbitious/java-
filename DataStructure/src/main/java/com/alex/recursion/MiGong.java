package com.alex.recursion;

public class MiGong {
    public static void main(String[] args) {
        //    创建一个二维数组 模拟迷宫
        int[][] map = new int[8][7];
        //    使用1表示墙 上下左右全部都置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        // map[1][2] = 1;
        // map[2][2] = 1;
        System.out.println("地图的情况=========");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j] + "\t");
            }
            System.out.println();
        }
        //    使用递归回溯给小球找路
        setWay2(map, 1, 1);
        System.out.println("小球走过，并且表示过的地图情况=========");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //    使用递归回溯来给小球找路
//    1 map 表示地图
//    2 i,j 表示从地图的哪个位置开始出发(1,1)
//    如果小球能到map[6][5]位置 则说明道路已经找到
//    当map[i][j]为0表示该点没有走过 当为1表示有墙不能通过，当为2时表示道路可以走 3表示该点已经走过 但是走不通
//  在走迷宫是 需要确定一个策略 按照下->右->上->左的顺序走路 如果该点走不通 再回溯
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//此点是终点 通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前的这个点还没有走过
                //    按照策略下->右->上->左
                map[i][j] = 2;//假定该点可以走通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上左
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点是走不通的 是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j] != 0
                return false;
            }
        }
    }

    //修改赵璐的策略
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//此点是终点 通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前的这个点还没有走过
                //    按照策略下->右->上->左
                map[i][j] = 2;//假定该点可以走通
                if (setWay2(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) {//向下左
                    return true;
                } else if (setWay2(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点是走不通的 是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j] != 0
                return false;
            }
        }
    }
}
