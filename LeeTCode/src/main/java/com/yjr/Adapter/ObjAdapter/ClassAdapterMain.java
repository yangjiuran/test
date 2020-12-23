package com.yjr.Adapter.ObjAdapter;

/**
 * @author yangjiuran
 * @Date 2020/7/13
 * 个人理解：
 *      Phone充电只能用5v的电压：现在有一个220V的电压，Phone就把自己需要的（5v定义成规则），
 *      定义一个类，让这个类去实现（5v规则），这个实现类只要持有220v的对象即可（成员变量，继承）
 *      或者如springMVC中的（dispatcherservlet），将对象直接放在方法中去传递
 */
public class ClassAdapterMain {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.Charging(new VoltageAdapterImpl2(),new Voltage220V());
    }
}
