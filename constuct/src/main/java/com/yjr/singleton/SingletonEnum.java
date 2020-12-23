package com.yjr.singleton;

/**
 * @author yangjiuran
 * 枚举类型，避免多线程同步的问题，还能防止反序列化重新创建对象
 * @Date 2019/12/9
 */
public enum  SingletonEnum {
    INSTANCE;
    public void getinstance(){

    }
}
