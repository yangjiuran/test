package com.yjr.algorithm;

/**
 * @author yangjiuran
 * @Date 2021/1/4
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int w[] = {1, 2, 3};
        int val[] = {1500, 2000, 3000};
        int v[][]=new int[val.length+1][5];
        int path[][]=new int[val.length+1][5];
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if(w[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else {
//                    v[i][j]=Math.max(v[i][j-1],val[i-1]+v[i-1][j-w[i-1]]);
                    if(v[i][j-1]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }else {
                        v[i][j]=v[i][j-1];
                    }
                }
            }
        }
        int i=path.length-1;
        int j=path[0].length-1;
       while (i>0&&j>0){
           if(path[i][j]==1){
               System.out.printf("第 %d个商品放入背包" ,i);
               j-=w[i-1];
           }
           i--;
       }
    }
}
