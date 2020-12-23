package com.yjr.Adapter.ClassAdapter;

/**
 * @author yangjiuran
 * @Date 2020/7/13
 */
public class ClassAdapterMain {
    public static void main(String[] args) {
        new Phone().Charging(new VoltageAdapterImpl2());
    }
}
