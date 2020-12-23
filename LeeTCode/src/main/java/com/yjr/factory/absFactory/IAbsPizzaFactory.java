package com.yjr.factory.absFactory;

import com.yjr.factory.pizza.Pizza;

/**
 * @author yangjiuran
 * @Date 2020/7/9
 */
public interface IAbsPizzaFactory {
    Pizza createPizza(String orderType);
}
