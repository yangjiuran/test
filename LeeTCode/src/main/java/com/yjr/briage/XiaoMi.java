package com.yjr.briage;

/**
 * @author yangjiuran
 * @Date 2020/7/16
 */
public class XiaoMi implements Brand{

    @Override
    public void open() {
        System.out.println("小米手机开机了~~");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机了~~~");
    }
}
