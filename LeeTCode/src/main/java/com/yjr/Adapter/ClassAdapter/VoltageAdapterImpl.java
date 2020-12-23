package com.yjr.Adapter.ClassAdapter;

/**
 * @author yangjiuran
 * @Date 2020/7/13
 */
public class VoltageAdapterImpl extends Voltage220V implements VoltageAdapter {
    @Override
    public int outPut() {
        int srcV = super.srcV();
        int dstV = srcV / 44;
        System.out.println("转换后的电压"+dstV+"v");
        return dstV;
    }
}
