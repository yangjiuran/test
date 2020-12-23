package com.yjr.strategy;

/**
 * @author yangjiuran
 * @Date 2020/9/1
 */
public class ClientDuck {
    public static void main(String[] args) {
        Duck pekingDuck = new PekingDuck("北京鸭子", new NoFlyBehavior());
        pekingDuck.fly();
        pekingDuck.setFlyBehavior(new GoodFlyBehavior());
        pekingDuck.fly();
    }
}
