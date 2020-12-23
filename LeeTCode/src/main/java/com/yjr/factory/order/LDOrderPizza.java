package com.yjr.factory.order;

import com.yjr.factory.pizza.*;

/**
 * @author yangjiuran
 * @Date 2020/7/8
 */
public class LDOrderPizza extends OrderPizza {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza=null;
       if("chesse".equals(orderType)){
           pizza= new LDChessesPizza();
       }else if("papper".equals(orderType)){
           pizza= new LDPapperPizza();
       }
       return pizza;
    }
}
