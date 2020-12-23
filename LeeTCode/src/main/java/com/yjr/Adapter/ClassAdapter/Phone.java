package com.yjr.Adapter.ClassAdapter;

/**
 * @author yangjiuran
 * @Date 2020/7/13
 */
public class Phone {
    public void Charging(VoltageAdapter adapter){
        if(adapter.outPut()==5){
            System.out.println("正在充电~~~");
        }else {
            System.out.println("电压不符合~~~");
        }
    }
}
