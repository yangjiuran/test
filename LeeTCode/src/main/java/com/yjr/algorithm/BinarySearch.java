package com.yjr.algorithm;

import com.yjr.dataStructure.psvm;

/**
 * @author yangjiuran
 * @Date 2020/12/31
 * 非递归形式的二分查找算法
 * 空间复杂度是 log以2 为底的n
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={9,10,11,20,21,25,30,40,100};
        int search = search(arr, 10);
        System.out.println(search);
    }
    public static int search(int[] arr,int target){
        if(arr.length<=0){
            return -1;
        }
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=((left+right)/2);
            if(target==arr[mid]){
                return mid;
            }else if(target<arr[mid]){
                right=mid-1;
            }else if(target>arr[mid]){
                left=mid+1;
            }else {
                return -1;
            }
        }
        return -1;
    }
}
