package com.yjr.factory.absFactory;

import com.yjr.factory.absFactory.impl.LDAbsFacatoryImpl;

/**
 * @author yangjiuran
 * @Date 2020/7/9
 */
public class AbsPizzaFactoryMain {
    public static void main(String[] args) {
        new OrderPizza(new LDAbsFacatoryImpl());
    }
}
