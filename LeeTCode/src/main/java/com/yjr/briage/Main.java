package com.yjr.briage;

/**
 * @author yangjiuran
 * @Date 2020/7/16
 *
 * 个人理解：
 *      当一个物品有多个维度描述时使用桥接：如手机（品牌，充电方式，颜色），此时可以将手机定义成抽象类，
 *      将 “品牌，充电方式，颜色”定义成接口，将在手机类中定义通用的属性如（开机，关机），当任一属性扩展时；
 *      对于抽象类而言
 */
public class Main {
    public static void main(String[] args) {
        OLEDPhone ledPhone = new OLEDPhone();
        XiaoMi xiaoMi = new XiaoMi();
        ledPhone.open(xiaoMi);
        ledPhone.close(xiaoMi);
    }
}
