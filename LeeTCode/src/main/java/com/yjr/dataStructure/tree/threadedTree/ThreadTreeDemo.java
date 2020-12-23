package com.yjr.dataStructure.tree.threadedTree;


import javafx.beans.binding.When;

/**
 * @author yangjiuran
 * @Date 2020/11/25
 */
public class ThreadTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "yjr");
        HeroNode node3 = new HeroNode(3, "www");
        HeroNode node8 = new HeroNode(8, "qqq");
        HeroNode node10 = new HeroNode(10, "rrr");
        HeroNode node6 = new HeroNode(6, "ttt");
        HeroNode node14 = new HeroNode(14, "xxxx");

        node6.setLeft(node14);
        node3.setLeft(node8);
        node3.setRight(node10);
        root.setLeft(node3);
        root.setRight(node6);
        ThreadTree yjr = new ThreadTree(root);
//        yjr.midThreadTreeNodes();
//        HeroNode heroNode = yjr.preFind(yjr.getRoot(), 10);
//        yjr.preThreadTreeNodes();
//        yjr.threadpreOrder();
        yjr.afterThreadTreeNodes();
        yjr.threadAfterOrder();
//        System.out.println(yjr);
    }
}

class ThreadTree {
    private HeroNode root;
    private HeroNode pre = null;

    public void threadTreeNodes() {
        this.midThreadTreeNodes(root);
    }

    public void preThreadTreeNodes() {
        this.preThreadTreeNodes(root);
    }

    public void afterThreadTreeNodes() {
        this.afterThreadTreeNodes(root);
    }


    public void threadMidOrder() {
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    public void threadpreOrder() {
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }

            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    public void threadAfterOrder() {
        HeroNode node = root;

        while (node.getLeftType() == 0) {
            node = node.getLeft();
        }
        System.out.println(node);
        while (node.getRightType() == 1) {
            node = node.getRight();
            System.out.println(node);
        }
        if (node != root) {
            node = root;
        }
        node = node.getRight();
        while (node.getRightType() == 0) {
            node = node.getRight();

        }
        System.out.println(node);
        while (node.getRightType() == 1) {
            node = node.getRight();
            System.out.println(node);
        }

    }

    /**
     * 生成中序线索二叉树
     *
     * @param node
     */
    public void midThreadTreeNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        midThreadTreeNodes(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        midThreadTreeNodes(node.getRight());

    }

    /**
     * 生成前序线索二叉树
     *
     * @param node
     */
    public void preThreadTreeNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        if (node.getLeftType() != 1) {
            preThreadTreeNodes(node.getLeft());
        }
        if (node.getRightType() != 1) {
            preThreadTreeNodes(node.getRight());
        }
    }

    /**
     * @return
     */
    public void afterThreadTreeNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeftType() != 1) {
            afterThreadTreeNodes(node.getLeft());
        }
        if (node.getRightType() != 1) {
            afterThreadTreeNodes(node.getRight());
        }
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
    }


    public HeroNode getRoot() {
        return root;
    }

    public ThreadTree(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root == null) {
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
        HeroNode reNode = null;
        System.out.println("前序遍历");
        if (parent.getNo() == no) {
            return parent;
        }
        reNode = preFind(parent.getLeft(), no);
        if (reNode != null) {
            return reNode;
        }
        reNode = preFind(parent.getRight(), no);
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
    public void delete(HeroNode parent, int no) {
        if (parent == null) {
            return;
        }
        if (parent.getNo() == no) {
            this.root = null;
            return;
        }
        if (parent.getLeft() != null && parent.getLeft().getNo() == no) {
            parent.setLeft(null);
            return;
        } else if (parent.getRight() != null && parent.getRight().getNo() == no) {
            parent.setRight(null);
            return;
        }
        delete(parent.getLeft(), no);
        delete(parent.getRight(), no);
    }

    /**
     * 删除2
     */
    public void delNode(int no) {
        if (this.root != null) {
            if (this.root.getNo() == no) {
                this.root = null;
            } else {
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
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

    public void delNode(int no) {
        if (this.left.getNo() == no) {
            this.left = null;
            return;
        }
        if (this.right.getNo() == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}
