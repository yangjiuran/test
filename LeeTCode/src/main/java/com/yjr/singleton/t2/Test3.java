package com.yjr.singleton.t2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangjiuran
 * @Date 2020/6/29
 * 静态内部类的方式实现单例模式
 */
public class Test3 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            pool.execute(()->{
                SingleTon singeton = SingleTon.getInstance();
                System.out.println("instance"+Thread.currentThread().getId()+"："+singeton.hashCode());
            });
        }
    }
}
class SingleTon{
    private  SingleTon(){}
    public static class SingleTonInstance{
        public static final SingleTon SINGLE_TON=new SingleTon();
    }

    public static SingleTon getInstance(){
        return SingleTonInstance.SINGLE_TON;
    }
}
