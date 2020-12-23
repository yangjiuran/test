package com.yjr.decorate.tearcher;

/**
 * @author yangjiuran
 * @Date 2020/7/21
 */
public class Soy extends Derocter {
    public Soy(Drink drink) {
        super(drink);
        setDes("豆浆");
        setPrice(3);
    }
}
