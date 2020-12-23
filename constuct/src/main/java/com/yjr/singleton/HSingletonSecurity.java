package com.yjr.singleton;

/**
 * @author yangjiuran
 * 单例模式-饿汉(线程安全)
 * @Date 2019/12/9
 */
public class HSingletonSecurity {
    private static HSingletonSecurity hSingleton;
    private HSingletonSecurity(){}
    private static synchronized HSingletonSecurity gethSingleton(){
        if(hSingleton==null){
            hSingleton=new HSingletonSecurity();
        }
        return hSingleton;
    }

}
