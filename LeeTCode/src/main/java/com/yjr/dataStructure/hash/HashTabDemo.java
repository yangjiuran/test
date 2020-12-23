package com.yjr.dataStructure.hash;

import javax.xml.bind.util.JAXBSource;
import java.util.OptionalDouble;

/**
 * @author yangjiuran
 * @Date 2020/11/18
 * hashtab 得思想是讲多个链表存储到一个数组或集合中，每个数据的存储的链表位置通过hash值来确定
 * list1 ->1 ->2
 * list2 ->3 ->4
 * list3 ->5 ->6
 * 通过这种打散存储的方式，可以由hash值在查找时快速的定位是哪一个链表存储的数据，在通过链表找到对应的数据
 * 以此在 数据量较大 的时可以快速的定位数据的位置
 *
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(10);
        Emp yjr = new Emp("yjr", 1);
        Emp ljj = new Emp("ljj", 2);
        Emp xxx = new Emp("xxx", 11);
        Emp ttt = new Emp("ttt", 20);
        Emp eee = new Emp("eee", 9);
        Emp qqq = new Emp("qqq", 12);
        hashTab.add(yjr);
        hashTab.add(ljj);
        hashTab.add(xxx);
        hashTab.add(qqq);
        hashTab.add(eee);
        hashTab.add(ttt);
        hashTab.list();
        hashTab.del(20);
        System.out.println();
        hashTab.list();
//        hashTab.find(6);
    }

    static class HashTab{
        Emplist[] emplists;

        public HashTab(int size) {
            emplists=new Emplist[size];
            for (int i = 0; i < size; i++) {
                emplists[i]=new Emplist();
            }
        }
        public void del(int id){
            int idHash = hash(id);
            emplists[idHash].delete(id);
        }

        public Emp find(int id){
            int idHash = hash(id);
            Emp emp = emplists[idHash].findById(id);
            if(emp!=null){
                System.out.printf("emplists[%d]",idHash);
                System.out.printf("\t => id=%d\tname=%s /",emp.getId(),emp.getName());
                return emp;
            }else {
                System.out.println("未找到");
                return null ;
            }
        }
        public void add(Emp emp){
            int i = hash(emp.id);
            emplists[i].add(emp);
        }
        public int hash(int id){
            return id%(emplists.length-1);
        }
        public void list(){
            for (int i = 0; i < emplists.length; i++) {
                System.out.printf("emplists[%d]",i);
                emplists[i].list();
                System.out.println();
            }
        }
    }
    static class Emplist {
        private Emp head;

        public void delete(int id){
            if(head==null){
                return;
            }
            Emp current=head;
            if(head.getId()==id){
                head=head.getNext();
                return;
            }
            while (true){
                if(current.getNext()==null){
                    current=null;
                    break;
                }
                if(current.getNext().getId()==id){
                    current.setNext(current.getNext().getNext());
                    break;
                }
                current=current.getNext();
            }
        }
        public Emp findById(int id){
            if(head==null){
                return null;
            }
            Emp curret=head;
            while (true){
                if(curret.getId()==id){
                    return curret;
                }
                if (curret.getNext()==null){
                    curret=null;
                    break;
                }
                curret=curret.getNext();
            }
            return curret;
        }
        public void add(Emp emp) {
            if (head == null) {
                head=emp;
                return;
            }
            Emp current = head;
            while (current.next != null) {
                current = current.getNext();
            }
            current.next = emp;
        }

        public void list(){
            if(head==null){
                return;
            }
            Emp current = head;
            while (true){
                System.out.printf("\t => id=%d\tname=%s /",current.getId(),current.getName());
                if(current.getNext()==null){
                    break;
                }
                current=current.getNext();
            }
        }
    }

    static class Emp {
        private String name;
        private int id;
        private Emp next;

        public Emp(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public Emp getNext() {
            return next;
        }

        public void setNext(Emp next) {
            this.next = next;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
