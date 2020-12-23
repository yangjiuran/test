package com.yjr;

/**
 * 最长无重复字符串：给定字符串找出其中不含字符串的最长字符串
 * @author yangjiuran
 * @Date 2020/6/10
 */
public class MaxNonredundantStr {
    public static void main(String[] args) {
        String stringa="abcabcabc";
        String s = find(stringa);
        System.out.println(s);
    }
    private static String find(String str){
        char[] chars = str.toCharArray();
        String s=str;
        StringBuilder tmp=new StringBuilder();
        char move=' ';
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]!=move){
                move=chars[i];
                tmp.append(move);

            }
            move=chars[i];

        }
        return tmp.toString();
    }
}
