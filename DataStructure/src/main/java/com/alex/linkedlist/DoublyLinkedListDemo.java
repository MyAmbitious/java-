package com.alex.linkedlist;

//双向链表的实现
class Node {
    public int data;
    public Node previous;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

class DoublyLinkedList {
    private Node head;//指向头节点的指针
    private Node tail;//指向尾节点的指针

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    //    插入数据到双向链表的尾部
    public void insertToTail(Node node) {
        if (isEmpty()) { //当链表中还没有元素的时候 直接移动尾指针
            tail = node;
            head=tail;

        } else {
            tail.next = node;
            node.previous = tail;
            tail = node; //记得移动尾指针
        }
    }

    //    插入数据到双向链表的头部
    public void insertToHead(Node node) {
        if (isEmpty()) {
            tail = node;
        } else {
            head.previous = node;
        }
        node.next = head;
        head = node;
    }

    public boolean isEmpty() {
        return head ==null;
    }

    //    遍历链表
    public void showDoublyLinkedList() {

        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp);
            temp=temp.next;
        }
    }
}

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList  = new DoublyLinkedList();
        doublyLinkedList.insertToHead(new Node(5));
        doublyLinkedList.insertToTail(new Node(4));
        doublyLinkedList.showDoublyLinkedList();
    }
}
