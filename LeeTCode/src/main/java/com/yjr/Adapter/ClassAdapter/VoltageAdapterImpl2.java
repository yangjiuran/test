package com.yjr.Adapter.ClassAdapter;

/**
 * @author yangjiuran
 * @Date 2020/7/13
 */
public class VoltageAdapterImpl2 extends Voltage220V implements VoltageAdapter {
    @Override
    public int outPut() {
        int srcV = super.srcV();
        int dstV = srcV / 55;
        System.out.println("转换后的电压"+dstV+"v");
        return dstV;
    }
}
