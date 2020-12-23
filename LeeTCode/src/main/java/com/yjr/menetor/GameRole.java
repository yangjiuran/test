package com.yjr.menetor;

/**
 * @author yangjiuran
 * @Date 2020/8/21
 */
public class GameRole {
    String name;
    int  health;

    public GameRole(String name, int health) {
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

    public Menetor saveMenetoy(){
        return new Menetor(this.name, this.health);
    }
}
