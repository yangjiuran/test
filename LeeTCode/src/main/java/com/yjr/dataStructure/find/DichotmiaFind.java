package com.yjr.dataStructure.find;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/11/12 190618
 * 二分查询，数组有序的情况下，每次折半
 */
public class DichotmiaFind {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 5 ,6, 7, 8, 9};
        List i = find(arr, 0, arr.length - 1, 5);
        System.out.println(i.toString());

    }

    public static List find(int[] arr, int left, int right, int value) {
        if (left > right) {
            return new ArrayList();
        }
        int mid = (left + right) / 2;

        if (value > arr[mid]) {
            return find(arr, mid+1, right, value);
        } else if(value < arr[mid]){
            return find(arr, left, mid-1, value);
        }else {
//            return mid;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(mid);
            int tmp=mid-1;
            while (true){
                if(tmp<0||arr[tmp]!=value){
                    break;
                }
                list.add(tmp);
                tmp-=1;
            }
            tmp=mid+1;
            while (true){
                if(tmp>arr.length||arr[tmp]!=value){
                    break;
                }
                list.add(tmp);
                tmp+=1;
            }
            return list;
        }
    }
}
