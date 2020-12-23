package com.yjr.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/11/20
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class LeetCode {
    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 5, 6};
        List list = get(arr, 7);
        list.forEach(a-> System.out.println(a));
    }

    public static List get(int[] arr, int num) {
        int i = 0;
        int j = 0;
        List list = new ArrayList<>();
        flag:
        for (i = 0; i < arr.length; i++) {
            for (j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == num) {
                    list.add("[" + i + "," + j + "]");
                }
            }
        }
        return list;
    }
}
