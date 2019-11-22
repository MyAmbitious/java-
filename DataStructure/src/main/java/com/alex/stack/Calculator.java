package com.alex.stack;
//用栈实现中缀表达式
public class Calculator {
    public static void main(String[] args) {
        //创建两个栈 一个数栈 一个符号栈
        String expression = "30+2*6-2-1";
        ArrayStack1 numStack = new ArrayStack1(10);
        ArrayStack1 operStack = new ArrayStack1(10);
        //    定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到的char保存到ch中
        String keepNum = "";//用于拼接多位数字
        //    开始while循环扫描experssion
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            //    判断ch是符号还是数字
            if (operStack.isOper(ch)) {
                //符号栈为空 则直接入栈
                if (!operStack.isEmpty() && operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                    //如果符号栈中有操作符 就进行比较 如果当前的操作符优先级小于或者等于栈中的操作符，就需要从数栈中弹出两个数，
                    // 从符号栈中弹出一个运算符 进行运算并将运算结果保存到栈中
                    oper = operStack.pop();
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    res = operStack.cal(num1, num2, oper);
                    System.out.println("此时res的值为：" + res);
                    numStack.push(res);
                }
                operStack.push(ch);
            } else {
                //如果是数字 则直接入栈
                // numStack.push(ch - 48);
                //当处理多位数时 不能发现是一个数就立即入栈 因为它可能是多位数
                //2在处理数时 需要向experssion的表达式的index后再看一位 如果是数就进行扫描 如果是符号才将此数入栈
                //定义一个变量字符串 用于拼接
                keepNum += ch;
                //    如果ch已经是expression的最后一位 或者向experssion的表达式的index后再看一位 如果是符号，将此数入栈就直接入栈
                if (index == expression.length() - 1|| operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum="";
                }

            }
            //让index+1，并且判断是否扫描到了experssion的最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕时 就顺序的从数栈和符号栈中pop出相应的数和符号 并计算
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            oper = operStack.pop();
            num1 = numStack.pop();
            num2 = numStack.pop();
            res = operStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        //数栈中最后的数字就是计算结果
        System.out.printf("表达式%s = %d", expression, numStack.pop());
        System.out.println();

    }
}

class ArrayStack1 {
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就放在该数组里面
    private int top = -1;//top表示栈顶 初始化为-1

    public ArrayStack1(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }


    //返回运算符的优先级别 数字越大 则优先级就越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;//用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
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
        System.out.printf("%d入栈成功！", value);
        System.out.println();
    }

    //    出栈操作
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已经空了，无法再次出栈");
        }
        return stack[top--];
    }

    //查询此时栈顶的元素是什么 不是真正的opp
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈已经空了，无法再次出栈");
        }

        return stack[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        //    从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \t", i, stack[i]);
            System.out.println();
        }
    }
}
