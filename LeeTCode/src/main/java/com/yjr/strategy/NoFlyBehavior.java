package com.yjr.strategy;

/**
 * @author yangjiuran
 * @Date 2020/9/1
 */
public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不能飞行");
    }
}
