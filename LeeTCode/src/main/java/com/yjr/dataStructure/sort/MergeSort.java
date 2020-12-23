package com.yjr.dataStructure.sort;

import com.yjr.responseChain.ThreeManager;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.Arrays;

/**
 * @author yangjiuran
 * @Date 2020/11/5
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr= {1,3,4,6,2,7,8,5};
        sort(arr,0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[]  arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            sort(arr,left,mid,temp);

            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right, temp);
        }
    }

    public static void merge(int arr[],int left,int mid,int right,int[] temp){
        int l=left;
        int j=mid+1;
        int tmp=0;

        while (l<=mid&&j<=right){
            if(arr[l]>=arr[j]){
                temp[tmp]=arr[j];
                j++;
                tmp++;
            }else {
                temp[tmp]=arr[l];
                l++;
                tmp++;
            }
        }
        while (l<=mid){
            temp[tmp]=arr[l];
            tmp++;
            l++;
        }
        while (j<=right){
            temp[tmp]=arr[j];
            tmp++;
            j++;
        }

        tmp=0;
        int tmpLeft=left;
        while (tmpLeft<=right){
         arr[tmpLeft]=temp[tmp];
         tmpLeft++;
         tmp++;
        }

    }
}
