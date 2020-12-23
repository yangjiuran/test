package com.yjr.other;

import java.util.Currency;

/**
 * @author yangjiuran
 * @Date 2020/11/23
 *  两数相加
 *  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode2 {
    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode2.setNext(listNode4);
        listNode4.setNext(listNode3);

        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(4);
        listNode5.setNext(listNode6);
        listNode6.setNext(listNode7);
        ListNode cur1=listNode2;
        ListNode cur2=listNode5;
        ListNode node = new ListNode();
        boolean flag=false;
        while (true){
            if(cur1==null&&cur2==null){
                if(flag){
                    node.add(new ListNode(1));
                }
                break;
            }else if(cur1==null){
                if(flag){
                    node.add(new ListNode(cur2.val+1));
                    flag=false;
                }else {
                    node.add(new ListNode(cur2.val));
                }
            }else if(cur2==null){
                if(flag){
                    node.add(new ListNode(cur1.val+1));
                    flag=false;
                }else {
                    node.add(new ListNode(cur1.val));
                }
            }else {
                if(flag){
                    int i = (cur1.val + cur2.val) % 10;
                    node.add(new ListNode(i+1));
                    flag=false;
                }else {
                    int i = (cur1.val + cur2.val) % 10;
                    node.add(new ListNode(i));
                }
                if((cur1.val+cur2.val)/10>0){
                    flag=true;
                }
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }
        node.list(node.getNext());
/*        int num1 = findNum(listNode2);
        int num2 = findNum(listNode5);
//        System.out.printf("%d+%d=%d",num1,num2,num1+num2);
        System.out.println("807%10="+(1807/10000)%10);
        System.out.println("807%10="+(1807/1000)%10);
        System.out.println("807%10="+(1807/100)%10);
        System.out.println("807%10="+(1807/10)%10);
        System.out.println("807%10="+(1807/1)%10);*/


    }
 /*   private static ListNode formatToNode(int num){
        int i=0;
        while (true){
            if(i>num){
                break;
            }
            int l = (num / i) % 10;
            ListNode listNode = new ListNode(l);
            i*=10;
        }
    }
    private static int findNum(ListNode node){
        ListNode cur=node;
        int i=0;
        int num=0;
        while (true) {
            if(cur==null){
                break;
            }
            Double pow = Math.pow(10, i);
            num=num+cur.val*(pow.intValue());
            cur=cur.next;
            i++;

        }
        return num;
    }*/
}


 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public int getVal() {
         return val;
     }

     public void setVal(int val) {
         this.val = val;
     }

     public ListNode getNext() {
         return next;
     }

     public void setNext(ListNode next) {
         this.next = next;
     }

     public void add(ListNode node){
         ListNode cur   =this;
         while (true){
             if(cur.getNext()==null){
                 break;
             }
             cur=cur.next;
         }
         cur.setNext(node);
     }

     public void list(ListNode node){
         ListNode cur   =node;
         while (true){
             if(cur==null){
                 break;
             }
             System.out.print(cur.val+"->");
             cur=cur.next;
         }
     }
     @Override
     public String toString() {
         return "ListNode{" + "val=" + val + ", next=" + next + '}';
     }
 }
