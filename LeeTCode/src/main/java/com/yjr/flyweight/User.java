package com.yjr.flyweight;

/**
 * @author yangjiuran
 * @Date 2020/7/30
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
