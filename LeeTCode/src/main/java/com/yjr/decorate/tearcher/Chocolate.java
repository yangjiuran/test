package com.yjr.decorate.tearcher;

/**
 * @author yangjiuran
 * @Date 2020/7/21
 */
public class Chocolate extends Derocter{
    public Chocolate(Drink drink) {
        super(drink);
        setDes("巧克力");
        setPrice(4);
    }
}
