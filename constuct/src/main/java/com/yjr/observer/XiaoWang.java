package com.yjr.observer;

/**
 * @author yangjiuran
 * @Date 2019/12/9
 */
public class XiaoWang implements Person {
    private String name ="小王";
    public XiaoWang(){
    }
    public void getMessage(String s) {
        System.out.println("接收到小美的消息，消息内容是"+s);
    }
}
