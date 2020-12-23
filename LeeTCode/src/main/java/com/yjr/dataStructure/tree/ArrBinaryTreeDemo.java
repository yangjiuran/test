package com.yjr.dataStructure.tree;

import java.util.Arrays;

/**
 * @author yangjiuran
 * @Date 2020/11/24
 * 顺序存储二叉树
 * 第n个节点 的左子节点是2*n+1
 * 第n个节点 的侧子节点是2*n+1
 * 第n个节点 父接点（n-1）/2
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrBinaryTree tree = new ArrBinaryTree();
        tree.midOrder(arr);//4251637
    }
}
class  ArrBinaryTree{

    public void preOrder(int[] arr){
        preOrder(arr,0);
    }
    public void midOrder(int[] arr){
        midOrder(arr,0);
    }
    public void preOrder(int[] arr,int no){
        System.out.println(arr[no]);
        if(2*no+1<arr.length){
            preOrder(arr,2*no+1);
        }
        if(2*no+2<arr.length){
            preOrder(arr,2*no+2);
        }
    }
    public void midOrder(int[] arr,int no){
        if(2*no+1<arr.length){
            midOrder(arr,2*no+1);
        }
        System.out.println(arr[no]);
        if(2*no+2<arr.length){
            midOrder(arr,2*no+2);
        }
    }
}
