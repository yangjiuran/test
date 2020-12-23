package com.yjr.decorate.tearcher;

/**
 * @author yangjiuran
 * @Date 2020/7/21
 */
public class Derocter extends Drink{
       private Drink drink;

    public Derocter(Drink drink) {
        this.drink = drink;
    }

    @Override
    public int cost() {
        return super.getPrice()+drink.cost();
    }
}
