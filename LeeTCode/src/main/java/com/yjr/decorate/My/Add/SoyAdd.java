package com.yjr.decorate.My.Add;

import com.yjr.decorate.My.Drink;
import com.yjr.decorate.My.caffee.ICoffee;

/**
 * @author yangjiuran
 * @Date 2020/7/20
 */
public class SoyAdd extends IAdd {

    public SoyAdd(Drink iCoffee) {
        super(iCoffee);
        setDes("豆浆");
        setPrice(3);
    }
}
