package com.alex.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public Integer no;
    public String name;
    public String nickname;
    public HeroNode next;
//    构造器

    public HeroNode(Integer no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

//定义SingleLinkedList 管理英雄
class SingleLinkedList {
    //先初始化一个头节点 ，注意 头结点不要动，也不要存放具体的数据
    private HeroNode head = new HeroNode(null, "", "");

    public HeroNode getHead() {
        return head;
    }

    //    添加节点到单向链表
//    思路 当不考虑编号的顺序的时候
//    1 ，找到当前链表的最后一个节点 直接插到链表尾部
//    2 将最后这个节点的next 指向新的节点
    public void addToRear(HeroNode heroNode) {

        HeroNode temp = this.head;
        while (temp.next != null) temp = temp.next;
        temp.next = heroNode;
    }

    //根据编号递增的顺序 来添加数据 若编号出现重复的现象 则不添加
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = this.head;
        boolean flag = false;//flag标志添加的编号是否存在 默认为false
        //因为是单链表 我们找到的temp节点是位于添加位置的前一个节点 否则插入不了
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;
        }
        if (flag) {//不能添加 说明编号已经存在
            System.out.printf("准备插入的英雄编号%d已经存在了，不能加入\n", heroNode.no);
        } else {
            //    插入到链表中 temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点信息 根据编号修改
    public void update(HeroNode newHeroNode) {
        //    判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = this.head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                //    找到
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("没有找到该节点:" + newHeroNode);
        } else {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }
    }

    //删除节点
    public void remove(HeroNode heroNode) {
        HeroNode temp = this.head;
        boolean flag = true;
        if (temp.next == null) {
            throw new RuntimeException("链表为空，不能删除");
        }
        while (true) {
            if (temp.next.no == heroNode.no) {
                break;
            }
            if (temp.next == null) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            throw new RuntimeException("链表中没有找到符合删除添加的节点");
        } else {
            temp.next = temp.next.next;
        }
    }


    //    遍历链表元素
    public void showLinkedList() {
        HeroNode temp = this.head.next;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

public class SingleLinkedListDemo {


    //方法：获取到单链表的节点得个数（如果是带头结点的链表，则不统计该头节点）
    public static int getLength(HeroNode head) {
        //    判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return -1;
        }
        HeroNode temp = head.next;
        int length = 0;
        while (temp != null) {//空链表
            length++;
            temp = temp.next;
        }
        return length;
    }

    //获取单链表中倒数第k个节点
    public static HeroNode getK(HeroNode head, int k) {
        if (head == null) {
            throw new RuntimeException("链表为空");
        }
        if (k <= 0) {
            throw new RuntimeException("输入的k值应该大于0");
        }
        HeroNode temp = head.next;
        HeroNode node = null;
        //    先获取链表中的有效节点个数
        final int length = getLength(head);
        if (length < k) {
            throw new RuntimeException("输入的k值过大，超过了链表长度");
        }
        // 获取倒数第K个节点 就是获取正数第(length-k+1)个节点
        for (int i = 1; i <= length - k + 1; i++) {
            node = temp;
            temp = temp.next;
        }
        return node;
    }


    //    （带头节点的）单链表反转
    public static void reverseLinkedList(HeroNode head) {
        //如果当前链表为空 或者只有一个节点 则无需反转，直接返回即可
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针变量，帮助我们遍历原来的链表
        HeroNode reverseHead = new HeroNode(null, "", "");
        HeroNode curl = head.next;
        HeroNode next = null;
        //遍历原来的链表 每遍历一个节点 就将其取出 并放在当前节点的下一个节点 因为后面需要使用
        while (curl != null) {
            next = curl.next; //先暂时保存当前节点的下一个节点 因为后面要用到
            curl.next = reverseHead.next;//每次变量 都将curl的下一个节点指向新的链表的最前端
            reverseHead.next = curl;//跟64 65 行将新节点插入到链表中的原理一样 “先连后 再断前”
            curl = next;//让cur后移
        }
        head.next = reverseHead.next;
    }

    //逆序打印单链表的所有节点--------思路：1利用栈的数据结构 2利用ArrayList
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            throw new RuntimeException("该链表为空，无法逆序打印");
        }
        HeroNode tmp = head.next;
        Stack<HeroNode> stack = new Stack<>();
        ArrayList<HeroNode> list = new ArrayList<>();
        while (tmp != null) {
            // stack.push(tmp);
            list.add(0,tmp);
            tmp = tmp.next;
        }
        // while (!stack.empty()) {
        //     System.out.println(stack.pop());
        // }
      for(HeroNode node :list){
          System.out.println(node);
      }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(new HeroNode(3, "宋江", "及时雨"));
        list.addByOrder(new HeroNode(2, "李逵", "黑旋风"));
        list.addByOrder(new HeroNode(4, "林冲", "豹子头"));
        list.addByOrder(new HeroNode(1, "吴用", "智多星"));
        list.addByOrder(new HeroNode(1, "吴用", "智多星"));
        list.showLinkedList();
        // System.out.println("----------修改节点测试------------");
        // list.update(new HeroNode(1, "宋江", "及时雨"));
        // list.showLinkedList();
        // System.out.println("--------------删除节点测试---------");
        // list.remove(new HeroNode(1, "宋江", "及时雨"));
        // list.showLinkedList();
        // System.out.println("-----------------获取到链表中有效节点的个数------------");
        // System.out.println(getLength(list.getHead()));
        // System.out.println("-----------------获取到链表中倒数第K个节点------------");
        // System.out.println(getK(list.getHead(),3));
        // System.out.println("-----------------单链表进行反转------------");
        // reverseLinkedList(list.getHead());
        // list.showLinkedList();

        System.out.println("逆序打印链表测试");
        reversePrint(list.getHead());
    }
}
