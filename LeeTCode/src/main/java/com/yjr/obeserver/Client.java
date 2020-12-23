package com.yjr.obeserver;

/**
 *  观察者模式
 * @author yangjiuran
 * @Date 2020/8/19
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.registry(new Baidu());
        weatherData.registry(new Xinlang());

        weatherData.setData(31F,100.0F,45F);
    }
}
