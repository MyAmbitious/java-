package com.alex.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(13);
        stack.push(23);
        stack.push(33);
        stack.display();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        // System.out.println(stack.pop());
    }
}

class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就放在该数组里面
    private int top = -1;//top表示栈顶 初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    //    栈满
    public boolean isFull() {
        //top指向数组的最后一个位置
        return top == maxSize - 1;
    }

    //    栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //    入栈操作
    public void push(int value) {
        //    先判断栈是否已经满了
        if (isFull()) {
            System.out.println("栈已满！无法再插入数据");
            return;
        }
        stack[++top] = value;
        System.out.printf("%d入栈成功！",value);
        System.out.println();
    }

    //    出栈操作
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已经空了，无法再次出栈");
        }
        return stack[top--];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
    //    从栈顶开始显示数据
        for(int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d \t",i,stack[i]);
            System.out.println();
        }
    }
}