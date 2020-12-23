package com.yjr.strategy;

/**
 * @author yangjiuran
 * @Date 2020/9/1
 */
public abstract class Duck {
    protected String name;
    protected FlyBehavior flyBehavior;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void fly(){
        System.out.println(name+"的飞行能力：");
        flyBehavior.fly();
    }
}
