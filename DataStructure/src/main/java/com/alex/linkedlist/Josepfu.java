package com.alex.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CreateCircleSingleLinkedList circleSingleLinkedList = new CreateCircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
        circleSingleLinkedList.showBoy();
        System.out.println("----------------------------------");
        circleSingleLinkedList.countBoy(1,2,25);
    }
}


//创建一个环形的单向链表
class CreateCircleSingleLinkedList {
    //创建一个first节点
    private Boy first = null;

    //    添加小孩子节点 构建出一个环形的链表
    public void addBoy(int nums) {
        //    对nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        //创建一个辅助指针 保证头节点不能动
        Boy curBoy = null;
        //    使用for循环来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            //    根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //    如果是第一个小孩的话
            if (1 == i) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = curBoy.getNext();
            }

        }
    }

    //    遍历当前的环形链表
    public void showBoy() {
        //    判断链表是否为空
        if (first == null) {
            throw new RuntimeException("没有任何小孩");
        }
        //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d \n", curBoy.getNo());
            curBoy = curBoy.getNext();
            if (curBoy == first) {
                break;
            }
        }
    }

    //根据用户的输入，计算出小孩出圈的顺序
    public void countBoy(int startNo, int countNum, int nums) {
        //    先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }


        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //    根据需求创建一个辅助指针（）helper，事先应该指向环形链表的最后这个节点
        for (; helper.getNext() != first; helper = helper.getNext()) ;
        //小孩报数前 先让first和helper移动k-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //    当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        //    这里是一个循环操作 直到全中只有一个节点
        while (true) {
            if (helper == first) {//说明圈中只有一个节点

                break;
            }
            // 让first和helper指针同时移动m-1次
           for(int i=0;i<countNum-1;i++){
               first = first.getNext();
               helper = helper.getNext();
           }
            //这时first指向的节点就是要出圈的小孩节点
            System.out.printf("小孩的编号%d \n", first.getNo());
            //执行小孩出圈操作
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在群众的小孩编号为%d \n",helper.getNo());
    }

}

class Boy {
    private int no;//小孩子的编号
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
