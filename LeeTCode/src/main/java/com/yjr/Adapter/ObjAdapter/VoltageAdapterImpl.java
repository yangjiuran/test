package com.yjr.Adapter.ObjAdapter;

/**
 * @author yangjiuran
 * @Date 2020/7/13
 */
public class VoltageAdapterImpl implements VoltageAdapter {

    @Override
    public int outPut5V(Voltage220V voltage) {
        int dstV=0;
        if(voltage!=null){
            int srcV = voltage.srcV();
            System.out.println("对象适配器转换了~~~");
            dstV = srcV / 44;
            System.out.println("转换后的电压"+dstV+"v");
        }
        return dstV;
    }
}
