package com.yjr.dataStructure.tree;

import com.sun.xml.internal.bind.v2.TODO;
import jdk.nashorn.internal.ir.IfNode;

/**
 * @author yangjiuran
 * @Date 2020/11/19
 */
public class BinarayTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(7, "yjr");
        HeroNode node2 = new HeroNode(2, "www");
        HeroNode node1 = new HeroNode(1, "qqq");
        HeroNode node3 = new HeroNode(3, "rrr");
        HeroNode node4 = new HeroNode(8, "ttt");
        HeroNode node5 = new HeroNode(9, "xxxx");
        HeroNode node10 = new HeroNode(10, "xxxx");
        HeroNode node11 = new HeroNode(11, "xxxx");
        HeroNode node13 = new HeroNode(13, "xxxx");
        BinaryTree yjr = new BinaryTree(root);
        yjr.insert(node1);
        yjr.insert(node2);
        yjr.insert(node10);
        yjr.insert(node5);
        yjr.insert(node3);
        yjr.insert(node4);
        yjr.insert(node11);
        yjr.insert(node13);
//        yjr.preOrder();
//        yjr.midOrder();
//        yjr.afterOrder();
        yjr.preOrder();
//        yjr.delete(yjr.getRoot(),7);
        yjr.delNode(7);
        System.out.println("删除过后");
        yjr.preOrder();
//        HeroNode heroNode2 = yjr.midFind(yjr.getRoot(), 8);
//        HeroNode heroNode = yjr.midFind(yjr.getRoot(), 9);
//        HeroNode heroNode = yjr.postFind(yjr.getRoot(), 9);


    }
}

class BinaryTree {
    private HeroNode root;



    public HeroNode getRoot() {
        return root;
    }

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if(this.root==null){
            System.out.println("当前树为空！");
            return;
        }
        this.root.preOrder();
    }

    public void midOrder() {
        this.root.midOrder();
    }

    public void afterOrder() {
        this.root.afterOrder();
    }

    /**
     * 我的理解 -插入
     */
    public void insert(HeroNode node) {
        HeroNode cur = root;
        while (true) {
            if (cur.getNo() > node.getNo()) {
                if (cur.getLeft() == null) {
                    cur.setLeft(node);
                    break;
                }
                cur = cur.getLeft();
            } else {
                if (cur.getRight() == null) {
                    cur.setRight(node);
                    break;
                }
                cur = cur.getRight();
            }
        }
    }

    /**
     * 前序查找
     */
    public HeroNode preFind(HeroNode parent, int no) {
        if (parent == null) {
            return parent;
        }
        HeroNode reNode=null;
        System.out.println("前序遍历");
        if(parent.getNo()==no){
            return parent;
        }
        reNode=preFind(parent.getLeft(),no);
        if(reNode!=null){
            return reNode;
        }
        reNode=preFind(parent.getRight(),no);
        return reNode;
    }

    /**
     * 中序查找
     */
    public HeroNode midFind(HeroNode parent, int no) {
        if (parent == null) {
            return parent;
        }
        HeroNode reNode = null;
        reNode = this.midFind(parent.getLeft(), no);
        if (reNode != null) {
            return reNode;
        }
        System.out.println("中序查找");
        if (parent.getNo() == no) {
            return parent;
        }
        reNode = this.midFind(parent.getRight(), no);

        return reNode;
    }

    /**
     * 后序查找
     */
    public HeroNode postFind(HeroNode parent, int no) {
        if (parent == null) {
            return parent;
        }
        HeroNode reNode = null;
        reNode = this.postFind(parent.getLeft(), no);
        if (reNode != null) {
            return reNode;
        }
        reNode = this.postFind(parent.getRight(), no);
        if (reNode != null) {
            return reNode;
        }
        System.out.println("后序遍历~");
        if (parent.getNo() == no) {
            return parent;
        }
        return reNode;
    }

    /**
     * 删除
     */
    public void delete(HeroNode parent,int no){
        if(parent==null){
            return;
        }
        if(parent.getNo()==no){
            this.root=null;
            return;
        }
        if(parent.getLeft()!=null&&parent.getLeft().getNo()==no){
            parent.setLeft(null);
            return;
        }else if(parent.getRight()!=null&&parent.getRight().getNo()==no){
            parent.setRight(null);
            return;
        }
            delete(parent.getLeft(),no);
            delete(parent.getRight(),no);
    }

    /**
     * 删除2
     */
    public void delNode(int no){
        if(this.root!=null){
            if(this.root.getNo()==no){
                this.root=null;
            }else {
                this.root.delNode(no);
            }
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;


    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历
    public void afterOrder() {
        if (this.left != null) {
            this.left.afterOrder();
        }
        if (this.right != null) {
            this.right.afterOrder();
        }
        System.out.println(this);
    }

    public void delNode(int no){
        if(this.left.getNo()==no){
            this.left=null;
            return;
        }
        if(this.right.getNo()==no){
            this.right=null;
            return;
        }
        if(this.left!=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
}
