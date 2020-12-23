package com.yjr.decorate.My.caffee;

import com.yjr.decorate.My.Drink;

/**
 * @author yangjiuran
 * @Date 2020/7/20
 */
public  class ICoffee extends Drink{
    @Override
    public int cost() {
        return super.getPrice();
    }
}
