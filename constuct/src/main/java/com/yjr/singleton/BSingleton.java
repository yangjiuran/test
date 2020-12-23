package com.yjr.singleton;

/**
 * @author yangjiuran
 * 单例模式-饱汉
 * @Date 2019/12/9
 */
public class BSingleton {
    private static BSingleton hSingleton=new BSingleton();
    private BSingleton(){}
    private static BSingleton gethSingleton(){
        return hSingleton;
    }

}
