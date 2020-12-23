package com.yjr.flyweight;

/**
 * @author yangjiuran
 * @Date 2020/7/30
 */
public abstract class WebSite {

    private String type="";
    public WebSite(String type) {
        this.type=type;
    }

    public abstract void show(User user);

    public abstract void open(User user);

    public abstract void down(User user);

}
