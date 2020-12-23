package com.yjr.dataStructure.doubleLinkedList;

import java.awt.*;

/**
 * @author yangjiuran
 * @Date 2020/10/13
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleList list = new DoubleList(new Node(0, null));
        list.addSort(new Node(1, "李逵"));
        list.addSort(new Node(2, "张飞"));
        list.addSort(new Node(3, "松江"));
        list.addSort(new Node(5, "张三丰"));
        list.addSort(new Node(4, "韩立"));

        list.list();
        System.out.println(list.size());

        System.out.println("删除第二个节点+++++++");
        list.delete(6);
        list.list();
/*        System.out.println("修改第二个节点++++");
        list.update(6, new Node(6, "yjr"));
        list.list();*/
    }
}

class DoubleList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public DoubleList(Node head) {
        this.head = head;
    }

    /**
     * 按序号顺序添加
     */
    public void addSort(Node node) {
        Node tmp = head;
        Boolean flag = false;
        while (tmp.next != null) {
            tmp = tmp.next;
            if (node.no < tmp.no) {
                flag = true;
                break;
            }
        }
        if(flag){
            tmp.pre.next=node;
            node.next=tmp;
            node.pre=tmp.pre;
            tmp.pre=node;
        }else {
            node.next=tmp.next;
            node.pre=tmp;
            tmp.next=node;
        }
    }

    /**
     * 修改,节点序号不可修改
     */
    public void update(int index, Node node) {
        Node tmp = head;
        if (head.next == null || index > size() || index < 0) {
            return;
        }
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        node=new Node(tmp.no, node.name);
        node.next = tmp.next;
        node.pre = tmp.pre;
        if (tmp.next != null) {
            tmp.next.pre = node;
        }
        tmp.pre.next = node;
    }

    /**
     * 删除
     */
    public void delete(int index) {
        Node tmp = head;
        if (head.next == null || index > size() || index < 0) {
            return;
        }
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        if (tmp.next != null) {
            tmp.next.pre = tmp.pre;
        }
        tmp.pre.next = tmp.next;
    }

    /**
     * 获取长度
     */
    public int size() {
        if (head.next == null) {
            return 0;
        }
        Node tmp = head;
        int size = 0;
        while (tmp.next != null) {
            tmp = tmp.next;
            size += 1;
        }
        return size;
    }

    /**
     * 添加
     */
    public void add(Node node) {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        node.pre = tmp;
    }

    /**
     * 遍历
     */
    public void list() {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.println(tmp);
        }
    }
}

class Node {
    public int no;
    public String name;
    public Node next;
    public Node pre;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

}
