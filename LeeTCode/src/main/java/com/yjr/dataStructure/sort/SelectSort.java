package com.yjr.dataStructure.sort;

import java.util.Arrays;

/**
 * @author yangjiuran
 * @Date 2020/10/28
 * 选择排序，每次找出最小值将最小值放到头
 *      第n次找到最小值，放到第n+1个位置（下标从0开始）
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={101,2,3,12};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 每次假设arr[i] 是最小值
     *  用arr[i] 更arr[i]之后的元素 比较，求出min,并找到minIndex
     *  将min换到i的位置
     *  arr[minIndex]=arr[i]
     *  arr[i]=min
     * 让i依次递增，到arr.length-2 是最后剩下的一个数就是最小的不用比较了
     *
     * @param arr
     */
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex=i;
            int min=arr[minIndex];
            for (int j = i; j < arr.length; j++) {
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(i!=minIndex){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
}
