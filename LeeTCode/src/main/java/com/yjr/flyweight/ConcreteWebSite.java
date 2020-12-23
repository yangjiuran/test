package com.yjr.flyweight;

/**
 * @author yangjiuran
 * @Date 2020/7/30
 */
public class ConcreteWebSite extends WebSite {


    public ConcreteWebSite(String type) {
        super(type);
    }

    @Override
    public void show(User user) {
        System.out.println(user.getName()+"ShoppingWebSite is show~~~");
}

    @Override
    public void open(User user) {
        System.out.println(user.getName()+"ShoppingWebSite is open~~~");
    }

    @Override
    public void down(User user) {
        System.out.println(user.getName()+"ShoppingWebSite is down~~~");
    }
}
