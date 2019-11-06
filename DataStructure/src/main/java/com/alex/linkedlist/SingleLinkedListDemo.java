package com.alex.linkedlist;

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
            if(temp.next==null){
                flag=false;
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("链表中没有找到符合删除添加的节点");
        }else {
            temp.next=temp.next.next;
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
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        // list.addToRear(new HeroNode(1, "宋江", "及时雨"));
        // list.addToRear(new HeroNode(2, "李逵", "黑旋风"));
        // list.addToRear(new HeroNode(4, "林冲", "豹子头"));
        // list.addToRear(new HeroNode(3, "吴用", "智多星"));

        list.addByOrder(new HeroNode(3, "宋江", "及时雨"));
        list.addByOrder(new HeroNode(2, "李逵", "黑旋风"));
        list.addByOrder(new HeroNode(4, "林冲", "豹子头"));
        list.addByOrder(new HeroNode(1, "吴用", "智多星"));
        list.addByOrder(new HeroNode(1, "吴用", "智多星"));
        list.showLinkedList();
        System.out.println("----------修改节点测试------------");
        list.update(new HeroNode(1, "宋江", "及时雨"));
        list.showLinkedList();
        System.out.println("--------------删除节点测试---------");
        list.remove(new HeroNode(1, "宋江", "及时雨"));
        list.showLinkedList();
    }
}
