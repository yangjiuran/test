package com.yjr.dataStructure.sort;

import com.yjr.Visitor.Fail;

import java.util.Arrays;

/** 冒泡排序
 * @author yangjiuran
 * @Date 2020/10/28
 * 思路：
 *  -1 -2 3 1 6
 *  假定两个指针，分别指向第一个和第二个元素，比较两个指针，若逆序则交换两个元素（如 -1>-2 则数组变为 -2 -1 3 1 6）
 *  指针依次递增
 *     每次比较确定一个最大值 第一次比较确定数组为3 -1 9 -2 10 故只要找出arr.lenth-1
 *     第一次比较只需要比较前4次即 arr.length -1-0
 *     第2次比较只需要比较前3次即 arr.length -1-1
 *     第3次比较只需要比较前3次即 arr.length -1-2
 *     第4次比较只需要比较前3次即 arr.length -1-3
 *     当进行了 arr.length -1 次比较后数组有序
 *
 * 时间复杂度 O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={3 ,9, -1, 10, -2};
        int tmp=0;
        boolean flag=false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {

                if(arr[j]>arr[j+1]){
                    flag=true;
                    tmp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                }
            }
            System.out.println("第"+(i+1)+"次比较后的数数组");
            System.out.println(Arrays.toString(arr));
            if(!flag){
                break;
            }else {
                flag=false;
            }
        }
    }
}
