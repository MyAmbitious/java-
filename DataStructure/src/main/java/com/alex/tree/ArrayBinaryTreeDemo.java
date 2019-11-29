package com.alex.tree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree =   new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
    }
}

class ArrayBinaryTree {
    private int[] arr;//存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }
    //    对顺序存储的二叉树的前序遍历
    public void preOrder(int index) {
        //    如果数组为空 或者arr.length=0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树进行前序遍历");
            return;
        }
        //    输出当前这个元素
        System.out.println(arr[index]);
        //    向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2*index+1);
        }
        //    向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2*index+2);
        }
    }
}
