package com.alex.queue;

//使用换新数组模拟队列

/**
 * 思路如下:
 * 1.  front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
 * front 的初始值 = 0
 * 2.  rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
 * rear 的初始值 = 0
 * 3. 当队列满时，条件是  (rear  + 1) % maxSize == front 【满】 预留一个元素 既rear指向front前面一个位置时 认为已满
 * 4. 对队列为空的条件， rear == front 空
 * 5. 当我们这样分析， 队列中有效的数据的个数   (rear + maxSize - front) % maxSize   // rear = 1 front = 0
 * 6. 我们就可以在原来的队列上修改得到，一个环形队列
 */
class CircleArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;// front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    private int rear;// 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    private int[] arr;//该数组用于存放数据 模拟队列

    public int[] getArr() {
        return arr;
    }

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头部
        rear = 0;//指向队列尾部 此处rear是指向队列尾部的后一个位置（重要）
    }

    //    判断队列是否已满
    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;//既rear指向front前面一个位置时 认为已满
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
        //   此处rear是指向队列尾部的后一个位置（重要）
        //    直接将数据加入
        arr[rear] = n;
        //    将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //    将队列中的对头元素删除
    public int getQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列已空，不能再删除数据");
        }
        /**
         * 这里需要分析出front是指向队列的第一个元素
         * 1 先把 front对应的值 保留到一个临时变量
         * 2 将front后移 考虑取模
         * 3 将临时保存的变量返回
         *
         */
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //    显示队列中的所有数据
    public void showQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列空的，无法遍历");
        }
        for (int a = this.front; a < this.front + size(); a++) {
            System.out.printf("arr[%d]=%d\n", a % maxSize, arr[a % maxSize]);
        }
    }

    //取出当前队列中有效数据的个数
    public int size() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return (this.rear + this.maxSize - this.front) % this.maxSize;
    }


    //    显示队列的头数据 注意不是取出数据
    public int headQueue() {
        //    判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的");
        }
        return this.arr[front];
    }


}

public class CircleArrayQueueDemo {


    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(5);//说明设置为4  其队列的有效数量最大为3 预留一个空闲空间
        queue.addQueue(5);
        queue.addQueue(6);
        queue.addQueue(15);
        queue.addQueue(50);
        queue.addQueue(51);
        queue.showQueue();
        final int i = queue.getQueue();
        System.out.println("移除队首元素：" + i);
        final int i1 = queue.getQueue();
        System.out.println("移除队首元素：" + i1);
        queue.showQueue();
        System.out.println("队列头部数据是：" + queue.headQueue());
        queue.addQueue(50);
        queue.addQueue(51);
        queue.showQueue();
    }
}
