package com.yjr.factory.absFactory.impl;

import com.yjr.factory.absFactory.IAbsPizzaFactory;
import com.yjr.factory.pizza.LDChessesPizza;
import com.yjr.factory.pizza.LDPapperPizza;
import com.yjr.factory.pizza.Pizza;

/**
 * @author yangjiuran
 * @Date 2020/7/9
 */
public class LDAbsFacatoryImpl implements IAbsPizzaFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza=null;
        if("chesse".equals(orderType)){
            pizza=new LDChessesPizza();
        }else if("pepper".equals(orderType)){
            pizza=new LDPapperPizza();
        }
        return pizza;
    }
}
