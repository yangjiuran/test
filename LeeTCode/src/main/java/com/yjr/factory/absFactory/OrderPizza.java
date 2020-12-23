package com.yjr.factory.absFactory;

import com.yjr.factory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangjiuran
 * @Date 2020/7/9
 */
public class OrderPizza {
    IAbsPizzaFactory iAbsPizzaFactory;

    public OrderPizza(IAbsPizzaFactory iAbsPizzaFactory) {
        this.setiAbsPizzaFactory(iAbsPizzaFactory);
    }

    private void setiAbsPizzaFactory(IAbsPizzaFactory iAbsPizzaFactory) {
        this.iAbsPizzaFactory = iAbsPizzaFactory;
        String orderType="";
        do {
            orderType=getType();
            Pizza pizza = iAbsPizzaFactory.createPizza(orderType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
        }while (true);

    }
    private String getType(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入要订购的pizza城市类型：");
            return  reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
