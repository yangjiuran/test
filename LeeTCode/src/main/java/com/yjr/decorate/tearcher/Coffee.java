package com.yjr.decorate.tearcher;

/**
 * @author yangjiuran
 * @Date 2020/7/21
 */
public class Coffee extends Drink{
    @Override
    public int cost() {
        return super.getPrice();
    }
}
