package com.yjr.factory.pizza;

/**
 * @author yangjiuran
 * @Date 2020/7/8
 */
public class BJChessesPizza implements Pizza {
    final String name ="beijin";
    final String type ="奶酪";

    @Override
    public void bake() {
        System.out.println(name+type+"pizza烘焙~~~");
    }

    @Override
    public void cut() {
        System.out.println(name+type+"pizza切开了");
    }

    @Override
    public void prepare() {
        System.out.println(name+type+"pizza准备材料了");
    }
}
