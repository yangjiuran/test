package com.yjr.dataStructure.annularLinkedList;

import sun.reflect.generics.tree.VoidDescriptor;

/**
 * 环形链表 and 约瑟夫环
 * @author yangjiuran
 * @Date 2020/10/14
 */
public class AnnulaLinkedListDemo {
    public static void main(String[] args) {
        AnnulaLinkedList listDemo = new AnnulaLinkedList();
        listDemo.outCurcle(1,2,5);
       /* listDemo.create(5);
        listDemo.list();*/
    }
}
class AnnulaLinkedList{
    Node head=null;
    /**
     * 约瑟夫环
     * index ->从第几个人开始报数
     * num ->每次数几个下
     * total -> 一共几个人
     */

    public void outCurcle(int index,int num,int total){
        if(total<0||index<0||num<0||index >total){
            return;
        }
        create(total);
        Node first=head;
        Node last=head;

        //将last指向first的前一个节点
        while(true){
            if(last.next==first){
                break;
            }
            last=last.next;
        }
        //将last和first都移动index次
        for (int i = 1; i < index; i++) {
            first=first.next;
            last=last.next;
        }
        //循环出圈
        //让first和last移动num-1(报数是包含自己)次，此时first就是要移除的节点
        //将first再次移动一次，再将end.next=first 完成指定节点出圈
        while (true){
            if(first==last){
                break;
            }
            for (int i = 0; i < num-1; i++) {
                first=first.next;
                last=last.next;
            }
            System.out.printf("第%d个节点出圈 \n",first.no);
            first=first.next;
            last.next=first;
        }
        System.out.printf("最后剩下的是节点%d \n",first.no);
    }
    /**
     * num 链表节点的个数
     * @param num
     */
    public void create(int num){
        Node cur=null;
        if(num<0){
            System.out.println("链表数量不能小于0");
            return;
        }
        for (int i = 0; i < num; i++) {
            Node node = new Node(i+1);
            if(i==0){
                head=node;
                cur=head;
            }
            cur.next=node;
            node.next=head;
            cur=cur.next;
        }
    }

    /**
     * 遍历链表 注意因为链表数环形的，需要有一个节点指向头结点
     */
    public void list(){
        Node cur=head;
        while (true){
            System.out.println(cur);
            if(cur.next==head) break;
            cur=cur.next;
        }
    }
}

class Node{
    public int no;
    public Node next;

    @Override
    public String toString() {
        return "Node{" + "no=" + no + '}';
    }

    public Node(int no) {
        this.no = no;
    }
}
