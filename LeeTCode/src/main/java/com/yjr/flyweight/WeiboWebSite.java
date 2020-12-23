package com.yjr.flyweight;

/**
 * @author yangjiuran
 * @Date 2020/7/30
 */
public class WeiboWebSite extends WebSite {


    public WeiboWebSite(String type) {
        super(type);
    }

    @Override
    public void show(User user) {
        System.out.println(user.getName()+"WeiboWebSite is show~~~");
    }

    @Override
    public void open(User user) {
        System.out.println(user.getName()+"WeiboWebSite is open~~~");
    }

    @Override
    public void down(User user) {
        System.out.println(user.getName()+"WeiboWebSite is down~~~");
    }
}
