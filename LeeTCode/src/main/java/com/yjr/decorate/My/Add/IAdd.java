package com.yjr.decorate.My.Add;

import com.yjr.decorate.My.Drink;
import com.yjr.decorate.My.caffee.ICoffee;

/**
 * @author yangjiuran
 * @Date 2020/7/20
 */
public class IAdd extends Drink {

    private Drink drink;

    public IAdd( Drink drink) {
        this.drink = drink;
    }

    @Override
    public int cost() {
        return super.getPrice()+ drink.cost();
    }
}
