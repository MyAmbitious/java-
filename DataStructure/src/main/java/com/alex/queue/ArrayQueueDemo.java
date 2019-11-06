package com.alex.queue;

//使用数组模拟队列  编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据 模拟队列

    public int[] getArr() {
        return arr;
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部 分析出front是指向队列头的前一个位置（重要）
        rear = -1;//指向队列尾部 指向队列尾的数据(记即使队列的最后一个数据) 添加数据 操作rear，减少数据 操作front
        //    既 添加元素到队尾 从对头删除元素
    }

    //    判断队列是否已满
    public boolean isFull() {
        return this.rear == maxSize - 1;
    }

    //    判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //    添加数据到队列
    public void addQueue(int n) {
        //    判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，不能再加入数据");
            return;
        }
        this.arr[++rear] = n;
        System.out.println("添加成功");
    }

    //    将队列中的对头元素删除
    public int getQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列已空，不能再删除数据");
        }
        return this.arr[++front];
    }

    //    显示队列中的所有数据
    public void showQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列空的，无法遍历");
        }
        for (int a = this.front + 1; a <= this.rear; a++) {
            System.out.println(this.arr[a]);
        }
    }

    //    显示队列的头数据 注意不是取出数据
    public int headQueue() {
        //    判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的");
        }
        return this.arr[front + 1];
    }


}

public class ArrayQueueDemo {


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.addQueue(5);
        queue.addQueue(6);
        queue.addQueue(15);
        queue.showQueue();
        final int i = queue.getQueue();
        System.out.println("移除队首元素：" + i);
        final int i1 = queue.getQueue();
        System.out.println("移除队首元素：" + i1);
        queue.showQueue();
        System.out.println("队列头部数据是："+queue.headQueue());
    }
}
