package com.yjr.dataStructure.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 思路：将数组转成大顶堆/小顶堆每次将最大/最小值放在根节点
 * 依次执行得到顺序的数组
 * @author yangjiuran
 * @Date 2020/12/2
 */
public class HeapSort {

    public static void main(String[] args) {
        int [] arr=new int[]{4,6,8,5,9,1,7,13,12,11};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        //对所有的非叶子节点进行调整，从最后一个非叶子节点开始调整
        for (int i=arr.length/2-1;i>=0;i--){
            ajust(arr,i,arr.length);
        }
        int temp=0;
        /**
         * 每次将数组的最后一位排除，因为最后一位是当前数组中最大的数，对新的数据重新转化成大顶堆；
         * 当仅仅剩下最后一位数时，一定是有序的了
         */
        for(int j=arr.length-1;j>0;j--){
            temp =arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            ajust(arr,0,j);
        }
    }
    /**
     * 调整最后一个传入的非叶子节点的子树
     * @param arr
     * @param i
     * @param length
     */
    public static void ajust(int[] arr,int i,int length){
        int temp=arr[i];
        for(int k=2*i+1;k<length;k=2*k+1){
            if(k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            /**
             * 此处先判断了左子节点和右子节点的大小
             * 而且因为该方法从倒数第一个非叶子节点开始排序，即第一次进来对一个节点i 最多只有两个叶子节点（不存在子树），
             * 所以节点i为该子树中的max
             * 因此每次节点i 只需要和他的左右节点进行比较即可，而在上一步判读中又找出了左右子节点的max（k）
             * 因此当左右子树为空且temp<arr[k]时发生交换即可；再条件不满足是就可以退出循环
             *  如果与之发生交换的 节点为非叶子节点则对其子树进行调整，找出最大的数放置在该侧节点上
             */
            if(temp<arr[k]){
                arr[i]=arr[k];
                i=k;
            }else {
             break;
            }
        }
        arr[i]=temp;
    }
}
