package com.yjr.obeserver;

/**
 * @author yangjiuran
 * @Date 2020/8/19
 */
public class Baidu implements Obeserver {
    private Float temperature;
    private Float humidity;
    private Float airPresure;
    @Override
    public void update(Float temperature, Float humidity, Float airPresure) {
        this.temperature=temperature;
        this.humidity=humidity;
        this.airPresure=airPresure;
        display();
    }

    public void display(){
        System.out.println("++++百度++++");
        System.out.println("气温"+this.temperature);
        System.out.println("湿度"+this.humidity);
        System.out.println("气压"+this.airPresure);
    }
}
