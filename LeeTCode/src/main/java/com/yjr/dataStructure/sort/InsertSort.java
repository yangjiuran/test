package com.yjr.dataStructure.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author yangjiuran
 * @Date 2020/10/28
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr={3,2,9,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 定义一有序数组，一次将无序数组插入到有序数组中
     * arr[0]是有序的，arr[1]<arr[0]则将arr[1]记录到一个临时变量tmp，arr[0]向后移动一位，既arr[1]=arr[0],再将arr[0]=tmp
     * 此时。前两个数字有序，将第三个数字按照之前的方法走一遍，依次类推
     *
     * @param arr
     */
    public static void sort(int[] arr){
        int insertIndex =0;
        int insertVal=0;
        for (int i = 1; i < arr.length; i++) {
            insertIndex =i-1;
            insertVal=arr[i];
            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex!=i){
                arr[insertIndex+1]=insertVal;
            }
        }
    }
}

