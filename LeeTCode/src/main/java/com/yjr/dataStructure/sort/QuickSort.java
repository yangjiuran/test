package com.yjr.dataStructure.sort;

import java.util.Arrays;

/**
 * @author yangjiuran
 * @Date 2020/11/4
 * 快速排序 ->是一种分区排序的的思想，先选定一个数，以此数为分界线，分别找出大于‘中点数’和小于‘中点数’的放在‘中点数’的两侧；
 * 依次递归上述算法，使得数组有序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={1,-2,0,7,0,-8,2};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int left,int right){
/*        int l=left;
        int r=right;
        int tmp=0;
        int pivot=arr[(left+right)/2];
        while (r>l){
            while (arr[l]<pivot){
                l+=1;
            }
            while (arr[r]>pivot){
                r-=1;
            }
            if(r<l){
                break;
            }
            tmp=arr[r];
            arr[r]=arr[l];
            arr[l]=tmp;
            if(arr[r]==pivot){
                r-=1;
            }
            if(arr[l]==pivot){
                l+=1;
            }
        }
        //如果l=r 必须r++，l--否则栈溢出
        if(l==r){
            l++;
            r--;
        }
        if(left<r){
            sort(arr,left,r);
        }
        if(right>l){
            sort(arr,l,right);
        }*/
    int l=left;
    int r=right;
    int tmp=0;
    int piovt=arr[(left+right)/2];
    while(r>l){
        while (arr[l]<piovt){
            l+=1;
        }
        while (arr[r]>piovt){
            r-=1;
        }
       /* if(r<l){
            break;
        }*/
        tmp=arr[l];
        arr[l]=arr[r];
        arr[r]=tmp;
        if(arr[r]==piovt){
            r-=1;
        }
        if(arr[l]==piovt){
            l+=1;
        }

    }
    if(l==r){
        l++;
        r--;
    }
    if(l<right){
        sort(arr,l,right);
    }
    if(r>left){
        sort(arr,left,r);
    }

    }

}
