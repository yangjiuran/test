package com.yjr.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/6/1
 */
public class LeetCode_t1 {
    public static void main(String[] args) {
        int[] candies =new int[]{2,3,5,1,3};
        List<Boolean> booleans = kidsWithCandies(candies, 3);
        System.out.println(booleans);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        for(int i=0;i<candies.length;i++){
            if(max<candies[i]){
                max=candies[i];
            }
        }
        System.out.println(max);
        ArrayList<Boolean> results = new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]!=max){
                if(max<=(candies[i]+extraCandies)){
                    results.add(true);
                }else {
                    results.add(false);
                }
            }else {
             results.add(true);
            }
        }
        return results;
    }
}
