package com.yjr.singleton;

/**
 * @author yangjiuran
 * 内部类的方式
 * @Date 2019/12/9
 */
public class SingletonInnerClass {
    private static class SingletonHolder{
        private static final SingletonInnerClass instance=new SingletonInnerClass();
    }
    private SingletonInnerClass(){}
    private static SingletonInnerClass getInstance(){
        return SingletonHolder.instance;
    }
}
