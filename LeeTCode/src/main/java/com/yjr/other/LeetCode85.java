package com.yjr.other;

import java.lang.reflect.Array;

/**
 * @author yangjiuran
 * @Date 2021/1/25
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class LeetCode85 {
    public static void main(String[] args) {
        char[][] a={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int i = maximalRectangle(a);
    }
    public static int maximalRectangle(char[][] matrix) {
        int maxSize=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int l = 0; l < matrix[i].length; l++) {
                if(matrix[i][l]=='1'){
                    if(matrix[i+1][l]=='1'||matrix[i][l+1]=='1'){
                        maxSize+=2;
                    }else if(matrix[i+1][l]=='1'&&matrix[i][l+1]=='1'&&matrix[i+1][l+1]=='1'){
                        maxSize+=3;
                    }
                }
            }
        }
        return maxSize;
    }

}
