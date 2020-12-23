package com.yjr.briage;

import java.security.Signature;

/**
 * @author yangjiuran
 * @Date 2020/7/16
 */
public class LEDPhone extends Phone {


    @Override
    public void open(Brand brand) {
        brand.open();
        System.out.println("led 屏幕开启了~~");
    }

    @Override
    public void close(Brand brand) {
        brand.close();
        System.out.println("led 屏幕关闭了~~");
    }
}
