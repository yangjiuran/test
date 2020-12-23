package com.yjr.Adapter.ObjAdapter;


/**
 * @author yangjiuran
 * @Date 2020/7/13
 */
public class VoltageAdapterImpl2 implements VoltageAdapter {
    @Override
    public int outPut5V(Voltage220V voltage220V) {
        int dstV=0;
        if(voltage220V!=null){
            int srcV = voltage220V.srcV();
            System.out.println("对象适配器转换了~~~");
            dstV = srcV / 55;
            System.out.println("转换后的电压"+dstV+"v");
        }
        return dstV;
    }
}
