package com.yjr.other;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yangjiuran
 * @Date 2021/1/25
 * 给你一个数字数组 arr 。
 *
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 *
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 */
public class LeetCode1502 {
    public static void main(String[] args) {
        int[] arr={1,6,3};
        boolean b = canMakeArithmeticProgression(arr);
        System.out.println(b);
    }
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            if(arr[i+1]-arr[i]!=arr[i+2]-arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
