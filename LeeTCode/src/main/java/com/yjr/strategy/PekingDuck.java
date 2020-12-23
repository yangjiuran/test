package com.yjr.strategy;

/**
 * @author yangjiuran
 * @Date 2020/9/1
 */
public class PekingDuck extends Duck{
    public PekingDuck(String name,FlyBehavior flyBehavior) {
        super.name=name;
        super.flyBehavior=flyBehavior;
    }
}
