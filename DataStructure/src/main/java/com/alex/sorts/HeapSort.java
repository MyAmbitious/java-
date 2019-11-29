package com.alex.sorts;


import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr)); //调整成最大堆的形式[9, 6, 8, 5, 4]
    }

    public static void heapSort(int[] arr) {

        // adjustHeap(arr, 1, arr.length);
        // System.out.println(Arrays.toString(arr));
        // adjustHeap(arr, 0, arr.length);
        // System.out.println(Arrays.toString(arr));
        //从第一个非叶子节点开始 向上进行遍历调整
        for(int i = arr.length/2-1;i>=0;i--){
            adjustHeap(arr, i, arr.length);
        }

        /**
         * 将堆顶元素与末尾元素交换 将最大元素“沉到”数组末端
         * 重新调整结构 使其满足堆定义 然后继续交换对顶元素和当前末尾元素 反复执行调用
         */
        int temp = 0;
        for(int j = arr.length-1;j>0;j--){
        //    交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }

    //利用数组构建最大堆进行升序排序

    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];//先取出当前元素的值 保存在临时变量中
        for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;//指向较大的节点
            }
            if (arr[j] > temp) {//进行比较
                arr[i] = arr[j]; //子树和其父节点交换值
                i = j;//循环往复 找到比左右子节点都比temp小的位置插入temp
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
