package com.yjr.flyweight;

/**
 * @author yangjiuran
 * @Date 2020/7/30
 */
public class Client {
    public static void main(String[] args) {
        WebSite shop = WebSiteFactory.getInstance("shop");
        User yjr = new User("yjr");
        shop.show(yjr);

        WebSite shop1 = WebSiteFactory.getInstance("shop");
        User ljj = new User("ljj");
        shop1.show(ljj);

        System.out.println(shop);
        System.out.println(shop1);
    }
}
