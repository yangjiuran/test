package com.yjr.factory.absFactory.impl;

import com.yjr.factory.absFactory.IAbsPizzaFactory;
import com.yjr.factory.pizza.*;

/**
 * @author yangjiuran
 * @Date 2020/7/9
 */
public class BJAbsFacatoryImpl implements IAbsPizzaFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza=null;
        if("chesse".equals(orderType)){
            pizza=new BJChessesPizza();
        }else if("pepper".equals(orderType)){
            pizza=new BJPapperPizza();
        }
        return pizza;
    }
}
