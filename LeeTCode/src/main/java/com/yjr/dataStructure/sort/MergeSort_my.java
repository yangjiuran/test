package com.yjr.dataStructure.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yangjiuran
 * @Date 2020/11/6
 */
public class MergeSort_my {
    public static void main(String[] args) {
        int[] arr={1,4,5,6,2,3,7,8};
        sort(arr,0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp){
        if(left<right){
            int mid =(left+right)/2;
            sort(arr,left,mid,temp);
            
            sort(arr,mid+1,right,temp);

            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int j = mid + 1;
        int t = 0;
        while (l <= mid && j <= right) {
            if (arr[l] >= arr[j]) {
                temp[t] = arr[j];
                j++;
                t++;
            } else {
                temp[t] = arr[l];
                l++;
                t++;
            }
        }
        while (l<=mid){
            temp[t]=arr[l];
            l++;
            t++;
        }
        while ( j <= right){
            temp[t]=arr[j];
            t++;
            j++;
        }

        t=0;
        int tmpleft=left;
        while (tmpleft<=right){
            arr[tmpleft]=temp[t];
            tmpleft++;
            t++;
        }
    }
}
