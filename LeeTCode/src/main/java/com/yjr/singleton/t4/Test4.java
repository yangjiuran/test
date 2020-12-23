package com.yjr.singleton.t4;

/**
 * @author yangjiuran
 * @Date 2020/6/29
 */
public class Test4 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        instance.method1();
    }
}
enum Singleton{
    INSTANCE;
    public void method1(){
        System.out.println("ok~");
    }
}