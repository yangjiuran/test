package com.yjr.decorate.My;

/**
 * @author yangjiuran
 * @Date 2020/7/22
 */
public abstract class Drink {
     private String des;
     private int price;

     public String getDes() {
          return des;
     }

     public void setDes(String des) {
          this.des = des;
     }

     public int getPrice() {
          return price;
     }

     public void setPrice(int price) {
          this.price = price;
     }

    public abstract int cost();
}
