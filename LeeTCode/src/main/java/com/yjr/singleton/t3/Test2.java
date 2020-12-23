package com.yjr.singleton.t3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangjiuran
 * @Date 2020/6/29
 */
public class Test2 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            pool.execute(()-> {
                    Singeton singeton = Singeton.getSingeton();
                    System.out.println("instance"+Thread.currentThread().getId()+"："+singeton.hashCode());
            });
        }
    }
}
class Singeton{
    private static volatile Singeton singeton;
    private Singeton(){};

    public static Singeton getSingeton() {
        if(singeton==null){
            synchronized (Singeton.class){
                if(singeton==null){
                    singeton=new Singeton();
                }
            }
        }
        return singeton;
    }
}
