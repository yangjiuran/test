package com.yjr.obeserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/8/19
 */
public class WeatherData implements Subject {
    private Float temperature;
    private Float humidity;
    private Float airPresure;
    private List<Obeserver> list;

    public WeatherData() {
        this.list=new ArrayList<>();
    }

    @Override
    public void registry(Obeserver Obeserver) {
        list.add(Obeserver);
    }

    @Override
    public void remove(Obeserver Obeserver) {
        if(list.contains(Obeserver)){
            list.remove(Obeserver);
        }
    }

    @Override
    public void notifiedObserver() {
        for (Obeserver obeserver : list) {
            obeserver.update(this.temperature,this.humidity,this.temperature);
        }
    }

    public void setData(Float temperature, Float humidity, Float airPresure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.airPresure=airPresure;

        notifiedObserver();
    }
}
