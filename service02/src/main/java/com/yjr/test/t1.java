package com.yjr.test;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangjiuran
 * @Date 2020/5/19
 */
public class t1 {
    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,4,5};
        int target=3;
        int[] ints = twoSum(a, target);
        System.out.println(ints);

    }
    public static Map<String, Object> removeList(List list){
        System.out.println(list);
        Map<String, Object> map = new HashMap<>();
        list.remove(0);
        map.put("reList",list);
        return map;
    }

    public static int[] twoSum(int[] nums, int target) {
        int x[]=new int[2];
        y:
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            for (int i2 = 0; i2 < nums.length; i2++) {
                if(k==nums[i2]){
                    x[0]=i;
                    x[1]=i2;
                    break y;
                }
            }
        }
        return x;
    }
}
