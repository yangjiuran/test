package com.yjr.decorate.tearcher;

import java.io.DataInputStream;

/**
 * @author yangjiuran
 * @Date 2020/7/21
 */
public class main {
    public static void main(String[] args) {
        Drink longblack = new Longblack();
        longblack = new Chocolate(longblack);
        longblack = new Chocolate(longblack);
        longblack = new Soy(longblack);
        System.out.println(longblack.cost());
    }
}
