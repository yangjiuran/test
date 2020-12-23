package com.yjr.briage;

/**
 * @author yangjiuran
 * @Date 2020/7/16
 */
public class OLEDPhone extends Phone {


    @Override
    public void open(Brand brand) {
        brand.open();
        System.out.println("OLED 屏幕开启了~~");
    }

    @Override
    public void close(Brand brand) {
        brand.close();
        System.out.println("OLED 屏幕关闭了~~");
    }
}
