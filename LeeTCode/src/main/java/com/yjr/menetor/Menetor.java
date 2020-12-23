package com.yjr.menetor;

/**
 * @author yangjiuran
 * @Date 2020/8/21
 */
public class Menetor {
    String name;
    int  health;

    public Menetor(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
