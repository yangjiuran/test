package com.yjr.observer;

/**
 * @author yangjiuran
 * @Date 2019/12/9
 */
public class PersonTest {
    public static void main(String[] args) {
        XiaoMei xiaoMei = new XiaoMei();
        XiaoQiang xiaoQiang = new XiaoQiang();
        XiaoWang xiaoWang = new XiaoWang();

        xiaoMei.addList(xiaoQiang);
        xiaoMei.addList(xiaoWang);
        xiaoMei.notifyPerson();
        System.out.println("方法执行完成");
    }
}
