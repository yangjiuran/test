package com.yjr.Adapter.ObjAdapter;

/**
 * @author yangjiuran
 * @Date 2020/7/13
 */
public class Phone {
    public void Charging(VoltageAdapter adapter,Voltage220V voltage){
        if(adapter.outPut5V(voltage)==5){
            System.out.println("正在充电~~~");
        }else {
            System.out.println("电压符合~~~");
        }
    }
}
