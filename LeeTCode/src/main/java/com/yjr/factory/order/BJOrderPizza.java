package com.yjr.factory.order;

import com.yjr.factory.pizza.BJChessesPizza;
import com.yjr.factory.pizza.BJPapperPizza;
import com.yjr.factory.pizza.Pizza;

/**
 * @author yangjiuran
 * @Date 2020/7/8
 */
public class BJOrderPizza extends OrderPizza {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza=null;
       if("chesse".equals(orderType)){
           pizza= new BJChessesPizza();
       }else if("papper".equals(orderType)){
           pizza= new BJPapperPizza();
       }
       return pizza;
    }
}
