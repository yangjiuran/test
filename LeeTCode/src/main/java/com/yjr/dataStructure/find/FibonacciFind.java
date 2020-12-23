package com.yjr.dataStructure.find;

import java.util.Arrays;

/**
 * @author yangjiuran
 * @Date 2020/11/17
 */
public class FibonacciFind {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr  ={1,3,5,56,78,91};
        int i = find(arr, 91);
        System.out.println(i);
    }

    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int find(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int[] f = fib();
        //f[k] 表示公有f[k]个元素
        while (high > f[k]-1) {
            k++;
        }

        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low=mid+1;
                k-=2;
            }else {
                if(mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
