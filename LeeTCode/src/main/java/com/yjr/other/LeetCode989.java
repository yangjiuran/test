package com.yjr.other;

import com.yjr.Intercept.AddSymbolExpression;

import java.io.PipedWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2021/1/22
 */
public class LeetCode989 {
    public static void main(String[] args) {
        int[] arr=new int[]{9,9,9,9,9,9,9,9,9,9,9};
        int k=121;
        List list = addToArrayForm(arr, k);
        System.out.println(list);

    }
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> resList = new ArrayList<Integer>();
        for(int i =A.length-1;i>=0;i--){
            int res = A[i] + (K % 10);
            K/=10;
            if(res>=10){
               K++;
               res-=10;
            }
            resList.add(res);
        }
        for (;K>0;K/=10){
            resList.add(K%10);
        }
        Collections.reverse(resList);
        return resList;
    }
  /* public static List<Integer> addToArrayForm(int[] A, int K) {
       List<Integer> res = new ArrayList<Integer>();
       int n = A.length;
       for (int i = n - 1; i >= 0; --i) {
           int sum = A[i] + K % 10;
           K /= 10;
           if (sum >= 10) {
               K++;
               sum -= 10;
           }
           res.add(sum);
       }
       for (; K > 0; K /= 10) {
           res.add(K % 10);
       }
       Collections.reverse(res);
       return res;
   }*/
}
