package com.yjr.other;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yangjiuran
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * @Date 2021/2/4
 */
public class LeetCode643 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        double v = findMaxAverage(nums, 4);
        System.out.println(v);
    }

    /**
     * 我的思路：逐个子数组求和
     * @param nums
     * @param k
     * @return
     */
     /* public static double findMaxAverage(int[] nums, int k) {
      int index = 0;
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        if(nums.length==k){
            for (int i1 = 0; i1 < k; i1++) {
                max += nums[index+i1];
            }
            list.add(max);
        }
        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            index = i;
            for (int i1 = 0; i1 < k; i1++) {
                sum += nums[index+i1];
            }
            list.add(sum);
        }
        Collections.sort(list);
        Double kdou = new Double(k);
        double v = list.get(list.size()-1) / kdou;
        return v;
    }*/

    /**
     * 官方滑动窗口的方式 sum[i+1]=sum[i]-nums[i]+nums[i+k+1]
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length ; i++) {
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
