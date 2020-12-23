package com.yjr.flyweight;

/**
 * @author yangjiuran
 * @Date 2020/7/30
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(100);
        Integer j = Integer.valueOf(100);
        System.out.println(i.hashCode()==j.hashCode());
        System.out.println(i);
        System.out.println(j);
        i=200;
        System.out.println("==============");
        System.out.println(i);
        System.out.println(j);
    }
}
