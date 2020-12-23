package com.yjr.decorate.My.Add;

import com.yjr.decorate.My.Drink;
import com.yjr.decorate.My.caffee.ICoffee;

/**
 * @author yangjiuran
 * @Date 2020/7/20
 */
public class MilkAdd extends IAdd {

    public MilkAdd(Drink drink) {
        super(drink);
        setDes("牛奶");
        setPrice(4);
    }
}
