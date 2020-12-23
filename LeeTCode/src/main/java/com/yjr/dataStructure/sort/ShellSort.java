package com.yjr.dataStructure.sort;

import java.util.Arrays;

/**
 * @author yangjiuran
 * @Date 2020/11/4
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr={3,5,4,7,8,9,11,0,1,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] array){
        for (int gap=array.length/2;gap>0;gap/=2){
            for (int i=gap;i<array.length;i++){
               int j=i;
               int tmp=array[j];
               if(array[j]<array[j-gap]){
                   while (j-gap>=0&&array[j]<array[j-gap]){
                       array[j]=array[j-gap];
                       j-=gap;
                   }
                   array[j]=tmp;
               }
            }
        }
    }
}
