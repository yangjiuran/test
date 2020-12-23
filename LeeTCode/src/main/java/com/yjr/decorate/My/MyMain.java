package com.yjr.decorate.My;

import com.yjr.decorate.My.Add.IAdd;
import com.yjr.decorate.My.Add.MilkAdd;
import com.yjr.decorate.My.Add.SoyAdd;
import com.yjr.decorate.My.caffee.EspressoCoffee;
import com.yjr.decorate.My.caffee.ICoffee;
import com.yjr.decorate.My.caffee.ShortBlackCoffee;
import com.yjr.decorate.tearcher.Coffee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/7/20
 */
public class MyMain {
    public static void main(String[] args) {
  /*      ShortBlackCoffee blackCoffee = new ShortBlackCoffee("黑咖啡");
        blackCoffee=new MilkAdd(blackCoffee, "牛奶").cost();
        new SoyAdd(blackCoffee, "豆浆").cost();*/
//        System.out.println(blackCoffee.cost());;
        Drink coffee = new ShortBlackCoffee();
        coffee = new MilkAdd(coffee);
        coffee = new MilkAdd(coffee);
        coffee = new SoyAdd(coffee);
        System.out.println(coffee.cost());
    }
}
