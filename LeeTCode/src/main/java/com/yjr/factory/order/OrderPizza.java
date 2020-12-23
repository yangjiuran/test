package com.yjr.factory.order;

import com.sun.scenario.effect.impl.prism.ps.PPSZeroSamplerPeer;
import com.yjr.factory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * @author yangjiuran
 * @Date 2020/7/8
 */
public abstract class OrderPizza {
    public abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        String orderType;
        do {
            orderType = getType();
            Pizza pizza = createPizza(orderType);
            pizza.prepare();
            pizza.cut();
            pizza.bake();
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
