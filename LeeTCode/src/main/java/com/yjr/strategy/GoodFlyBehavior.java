package com.yjr.strategy;

/**
 * @author yangjiuran
 * @Date 2020/9/1
 */
public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞行能力强");
    }
}
