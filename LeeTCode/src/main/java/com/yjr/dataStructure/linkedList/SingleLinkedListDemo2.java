package com.yjr.dataStructure.linkedList;

import com.yjr.responseChain.ThreeManager;

import javax.sound.midi.Soundbank;
import java.lang.reflect.GenericArrayType;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author yangjiuran
 * @Date 2020/9/16
 */
public class SingleLinkedListDemo2 {
    public static void main(String[] args) {
        Node2 node_2 = new Node2(2, "小红");
        Node2 node_1 = new Node2(1, "小明");
        Node2 node_4 = new Node2(4, "小青");
        Node2 node_3 = new Node2(3, "小绿");

        SingleLinkedList2 singleLinkedList = new SingleLinkedList2();
        singleLinkedList.add(node_1);
        singleLinkedList.add(node_3);
        singleLinkedList.add(node_2);
        singleLinkedList.add(node_4);

        Node2 node_5 = new Node2(5, "小红");
        Node2 node_6 = new Node2(6, "小明");
        Node2 node_7 = new Node2(7, "小青");
        Node2 node_8 = new Node2(8, "小绿");

        SingleLinkedList2 singleLinkedList2 = new SingleLinkedList2();
        singleLinkedList2.add(node_5);
        singleLinkedList2.add(node_6);
        singleLinkedList2.add(node_7);
        singleLinkedList2.add(node_8);
//        singleLinkedList.update(new Node2(3,"杨久冉"));
        singleLinkedList.list();
        System.out.println("++++++++++");

        singleLinkedList.del(new Node2(3, "杨久冉"));

        System.out.println("链表长度：" + singleLinkedList.length());

        singleLinkedList.list();

        System.out.println("反转的列表" + "++++++++++++++");
        singleLinkedList.reserve(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("逆序打印" + "++++++++++++++");
        singleLinkedList.reserve(singleLinkedList.getHead());
        singleLinkedList.reservePrint(singleLinkedList.getHead());

        System.out.println("合并链表++++++++++++++++");
        Node2 concat = singleLinkedList.concat(singleLinkedList.getHead(), singleLinkedList2.getHead());
        Node2 tmp = concat;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
            System.out.println(tmp.toString());
        }
/*
        System.out.printf("获取第%d个元素:" + singleLinkedList.getByIndex(singleLinkedList.getHead(), 3), 3);
        System.out.println();
        System.out.printf("获取倒数第%d个元素:" + singleLinkedList.getLastIndexNode(singleLinkedList.getHead(), 1), 1);*/
    }
}

class SingleLinkedList2 {
    private Node2 head = new Node2(0, null);

    public Node2 getHead() {
        return head;
    }

    public void add(Node2 node) {
        Node2 tmp = head;
        boolean flag = true;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            if (tmp.getNext().getNo() > node.getNo()) {
                break;
            } else if (tmp.getNo() > node.getNo()) {
                System.out.println("当前节点已存在");
                flag = false;
                break;
            }
            tmp = tmp.getNext();
        }
        if (flag) {
            node.setNext(tmp.getNext());
            tmp.setNext(node);
        }

    }


    public void list() {
        Node2 tmp = head;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
            System.out.println(tmp.toString());
        }
    }

    public void update(Node2 node) {
        Node2 tmp = head;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            if (tmp.getNext().getNo() == node.getNo()) {
                break;
            }
            tmp = tmp.getNext();
        }
        if (tmp.getNext() != null) {
            node.setNext(tmp.getNext().getNext());
        }
        tmp.setNext(node);

    }

    public void del(Node2 node) {
        Node2 tmp = head;
        boolean flag = false;
        if (tmp.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            if (tmp.getNext().getNo() == node.getNo()) {
                flag = true;
                break;
            }
            tmp = tmp.getNext();
        }
        if (flag) {
            tmp.setNext(tmp.getNext().getNext());
        }
    }

    public int length() {
        if (head.getNext() == null) {
            return 0;
        }
        Node2 tmp = head.getNext();
        int i = 0;
        while (true) {
            i = i + 1;
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
        }
        return i;
    }

    public Node2 getByIndex(Node2 head, int index) {
        int i = 0;
        Node2 tmp = head;
        boolean find = true;
        while (true) {
            if (index == i) {
                break;
            } else if (tmp.getNext() == null) {
                find = false;
                break;
            }
            i = i + 1;
            tmp = tmp.getNext();
        }
        if (find) {
            return tmp;
        } else {
            return null;
        }
    }

    public Node2 getLastIndexNode(Node2 head, int index) {
        if (head.getNext() == null) {
            return null;
        }

        Node2 cur = head.getNext();
        int size = length();
        if (index < 0 || index > size) {
            return null;
        }
        for (int i = 0; i < size - index; i++) {
            cur = cur.getNext();
        }
        return cur;
    }

    /**
     * 反转
     *
     * @param head
     */
    public void reserve(Node2 head) {
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        Node2 cur = head.getNext();
        Node2 cur_next = null;
        Node2 new_head = new Node2(0, null);
        while (true) {
            if (cur == null) {
                break;
            }
            cur_next = cur.getNext();
            cur.setNext(new_head.getNext());
            new_head.setNext(cur);
            cur = cur_next;
        }
        head.setNext(new_head.getNext());
    }

    /**
     * 逆序打印
     *
     * @param head
     */
    public void reservePrint(Node2 head) {
        if (head.getNext() == null) {
            return;
        }
        Stack<Node2> stack = new Stack<>();
        Node2 cur = head.getNext();
        while (true) {
            stack.push(cur);
            if (cur.getNext() == null) {
                break;
            }
            cur = cur.getNext();
        }
        while (!stack.empty()) {
            System.out.println(stack.pop().toString());
        }
    }

    /**
     * 合并两个有序单链表 且合并后的单链表有序
     *
     * @param head1
     * @param head2
     */
    public Node2 concat(Node2 head1, Node2 head2) {
        if(head1.getNext()==null){
            return head2;
        }if(head2.getNext()==null){
            return head1;
        }
        Node2 cur1 = head1;
        Node2 cur2 = head2;
        while (true){
            if(cur1.getNext()==null){
                break;
            }
            Node2 next1 = cur1.getNext();
            while (true){
                if(cur2.getNext()==null){
                    break;
                }
                Node2 next2 = cur2.getNext();
                if(next1.getNo()<next2.getNo()){
                    next1.setNext(next2);
                    cur2.setNext(next1);
                }
                cur2=cur2.getNext();
            }
            cur1=cur1.getNext();
        }
        return head1;
    }
}

class Node2 {
    private int no;
    private String name;
    private Node2 next;

    public Node2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }
}
