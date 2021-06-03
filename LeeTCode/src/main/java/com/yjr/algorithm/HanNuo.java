package com.yjr.algorithm;

/**
 * @author yangjiuran
 * @Date 2020/12/31
 * 汉诺塔
 */
public class HanNuo {
    public static void main(String[] args) {
        start(2,'A','B','C');
    }

    public static void start(int num, char a, char b, char c) {
        if(num==1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else {
            start(num-1,a,c,b);
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            start(num-1,b,a,c);
        }
    }
}
