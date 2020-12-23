package com.yjr.dataStructure.linkedList;

import com.yjr.dataStructure.psvm;
import javafx.scene.shape.VLineTo;

import javax.swing.*;
import java.util.Stack;

/**
 * @author yangjiuran
 * @Date 2020/9/16
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "小明");
        Node node2 = new Node(7, "小红");
        Node node3 = new Node(5, "小绿");
        Node node4 = new Node(2, "小青");

        SingleLinkedList singleLinkedList = new SingleLinkedList(new Node(0, null));
/*        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);*/
        singleLinkedList.addSort(singleLinkedList.getHead(), node1);
        singleLinkedList.addSort(singleLinkedList.getHead(), node2);
        singleLinkedList.addSort(singleLinkedList.getHead(), node3);
        singleLinkedList.addSort(singleLinkedList.getHead(), node4);

        singleLinkedList.list(singleLinkedList.getHead());
        singleLinkedList.update(singleLinkedList.getHead(), new Node(2, "yjr"));

        System.out.println("修改后-----------");
        singleLinkedList.list(singleLinkedList.getHead());

        System.out.printf("有效的链表长度 %d", singleLinkedList.size(singleLinkedList.getHead()));
        System.out.println("--------------");
        System.out.printf("倒数第 %d个节点是：" + singleLinkedList.getReverseIndexNode(singleLinkedList.getHead(), 1), 1);
        System.out.println("倒转前-----------");
        singleLinkedList.list(singleLinkedList.getHead());
        System.out.println();
//        System.out.println("倒转后-----------");
//        singleLinkedList.reverse(singleLinkedList.getHead());
//        singleLinkedList.list();

        System.out.println("倒转后2-----------");
        singleLinkedList.reverseMethod2(singleLinkedList.getHead());
        singleLinkedList.list(singleLinkedList.getHead());

        System.out.println("逆序打印————————————");
        singleLinkedList.printReverse(singleLinkedList.getHead());

        Node node5 = new Node(8, "大明");
        Node node6 = new Node(9, "大红");
        Node node7 = new Node(10, "大绿");
        Node node8 = new Node(11, "大青");


        SingleLinkedList singleLinkedList2 = new SingleLinkedList(new Node(0, null));
/*        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);*/
        singleLinkedList2.addSort(singleLinkedList2.getHead(), node5);
        singleLinkedList2.addSort(singleLinkedList2.getHead(), node6);
        singleLinkedList2.addSort(singleLinkedList2.getHead(), node7);
        singleLinkedList2.addSort(singleLinkedList2.getHead(), node8);

        System.out.println("合并链表————————————");
        Node merge = singleLinkedList.merge(singleLinkedList.getHead(), singleLinkedList2.getHead());
        singleLinkedList.list(merge);

    }
}

class SingleLinkedList {
    private Node head;

    public SingleLinkedList(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }


    /**
     * 链表合并
     */
    public Node merge(Node headNode1, Node headNode2) {
        Node cur1 = headNode1.getNext();
        Node cur2 = headNode2.getNext();
        Node next1 = null;
        Node next2 = null;
        SingleLinkedList list = new SingleLinkedList(new Node(0, null));
        while (true) {
            if (cur1 == null) {
                break;
            }
            next1 = cur1.getNext();
            list.addSort(list.getHead(), cur1);
            cur1 = next1;
        }
        while (true) {
            if (cur2 == null) {
                break;
            }
            next2 = cur2.getNext();
            list.addSort(list.getHead(), cur2);
            cur2 = next2;
        }
        return list.getHead();
    }


    /**
     * 逆序打印
     * 利用‘栈’的先进后出的特点，逆序打印
     */
    public void printReverse(Node headNode) {
        if (headNode.getNext() == null) return;
        Node tmp = headNode.getNext();
        Stack<Node> nodes = new Stack<>();
        while (true) {
            if (tmp == null) {
                break;
            }
            nodes.add(tmp);
            tmp = tmp.getNext();
        }
        while (!nodes.empty()) {
            System.out.println(nodes.pop());
        }
    }

    /**
     * 链表的倒转 method1
     */
    public void reverse(Node headNode) {
        SingleLinkedList listNew = new SingleLinkedList(new Node(0, null));
        int size = this.size(headNode);
        for (int i = 1; i <= size; i++) {
            Node reverseIndexNode = getReverseIndexNode(headNode, i);
            if (reverseIndexNode != null && reverseIndexNode.getNext() != null) reverseIndexNode.setNext(null);
            if (reverseIndexNode != null) listNew.add(listNew.getHead(), reverseIndexNode);
        }
        headNode.setNext(listNew.getHead().getNext());
    }

    /**
     * 链表的倒转 method2
     */
    public void reverseMethod2(Node headNode) {
        if (headNode.getNext() == null) return;
        /**
         * 此处如果不是取head的next 会造成循环引用，即倒转后 rev->node1->node2->node3->head
         * 再此时将 rev.next->head
         * 则
         *      head->node1->node2->node3-> head->node1->node2->node3->head->node1......
         * 结论：java中的只有引用传递，head引用的修改造成head的循环引用
         */
        Node cur = headNode.getNext();
        Node next = null;
        Node rev = new Node(0, null);
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(rev.getNext());
            rev.setNext(cur);
            cur = next;
        }
        headNode.setNext(rev.getNext());
    }

    /**
     * 倒数第k个节点
     */
    public Node getReverseIndexNode(Node headNode, int index) {
        if (headNode.getNext() == null) {
            return null;
        }
        int size = this.size(headNode);
        if (index < 0 || index > size) {
            return null;
        }
        Node tmp = headNode.getNext();
        for (int i = 0; i < size - index; i++) {
            tmp = tmp.getNext();
        }
//        tmp.setNext(null);
        return new Node(tmp.getNo(), tmp.getName());
    }

    public int size(Node headNode) {
        int size = 0;
        if (headNode.getNext() == null) {
            return size;
        }
        Node tmp = headNode.getNext();
        while (true) {
            size += 1;
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
        }
        return size;
    }

    //更新节点
    public void update(Node headNode, Node node) {
        Node tmp = headNode;
        Boolean flag = false;
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
            tmp.getNext().setName(node.getName());
        } else {
            System.out.println("为找到该节点");
        }
    }

    //添加节点
    public void add(Node headNode, Node node) {
        //通过临时变量找到尾结点（）
        Node tmp = headNode;
        while (true) {
            //尾结的next为空
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
        }
        tmp.setNext(node);
    }


    public void addSort(Node headNode, Node node) {
        Node tmp = headNode;
        Boolean flag = false;
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            if (tmp.getNext().getNo() > node.getNo()) {
                break;
            } else if (tmp.getNext().getNo() == node.getNo()) {
                flag = true;
                break;
            }
            tmp = tmp.getNext();
        }
        if (flag) {
            System.out.printf("序号 %d 已经存在", node.getNo());
        } else {
            node.setNext(tmp.getNext());
            tmp.setNext(node);
        }
    }

    /**
     * 遍历链表
     */
    public void list(Node headNode) {
        Node tmp = headNode;
        if (tmp.getNext() == null) {
            System.out.println("链表为空");
        }
        while (true) {
            if (tmp.getNext() == null) {
                break;
            }
            tmp = tmp.getNext();
            System.out.println(tmp.toString());
        }
    }
}

class Node {
    private int no;
    private String name;
    private Node next;

    public Node(int no, String name) {
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

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
