package com.yjr.dataStructure.sort;

import java.util.Arrays;

/**
 * @author yangjiuran
 * @Date 2020/12/2
 */
public class HeapSort2 {
    public static void main(String[] args) {
        int[] arr=new int[]{4,6,8,5,9,1,7,13,12,11};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        for(int i=arr.length/2-1;i>=0;i--){
            ajust(arr,i,arr.length);
        }
        int temp=0;
        for (int j=arr.length-1;j>0;j--){
            temp=arr[0];
            arr[0]=arr[j];
            arr[j]=temp;
            ajust(arr,0,j);
        }

    }
    public static void ajust(int[] arr ,int i ,int len){
        int temp=arr[i];
        for(int k=2*i+1;k<len;k=2*k+1){
            if(k+1<len&&arr[k]<arr[k+1]){
                k++;
            }
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
