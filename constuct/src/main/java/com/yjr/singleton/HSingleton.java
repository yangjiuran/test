package com.yjr.singleton;

/**
 * @author yangjiuran
 * 单例模式-饿汉(线程不安全)
 * @Date 2019/12/9
 */
public class HSingleton {
    private static HSingleton hSingleton;
    private HSingleton(){}
    private static HSingleton gethSingleton(){
        if(hSingleton==null){
            hSingleton=new HSingleton();
        }
        return hSingleton;
    }

}
