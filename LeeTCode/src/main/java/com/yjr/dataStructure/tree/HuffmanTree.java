package com.yjr.dataStructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 * @author yangjiuran
 * @Date 2020/12/4
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[]arr=new int[]{13,7,8,3,29,6,1};
        Node tree = getTree(arr);
        preOrder(tree);
    }

    public static void preOrder(Node node){
        node.preOrder();
    }
    /**
     * 1.构建节点，放入list 将节点排序
     * 2.取出权值最小的连个节点，分别为左右节点，以两个节点的权值之和构建父节点
     * 3.将构建出的父节点放入list,移除之前的连个节点
     * 4.重复1,2,3，当list中剩下最后一个节点是即为赫夫曼树的根节点
     * @param arr
     * @return
     */
    public static Node getTree(int[] arr){
        List<Node> list =new ArrayList<>();
        for (int i : arr) {
            list.add(new Node(i));
        }
        while (list.size()>1){
            Collections.sort(list);
            Node left=list.get(0);
            Node right=list.get(1);
            Node parent=new Node(left.val+right.val);
            parent.left=left;
            parent.right=right;

            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        return list.get(0);
    }
}
class Node implements Comparable<Node> {

    int val;
    Node left;
    Node right;

    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" + "val=" + val + '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}
