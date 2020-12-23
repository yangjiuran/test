package com.yjr.singleton.t1;

/**
 * @author yangjiuran
 * @Date 2020/6/29
 * 单例模式（饿汉式）
 */
public class Test1 {
    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        SingleTon instance1 = SingleTon.getInstance();
        System.out.println(instance==instance1);
    }
}
/**将静态方法私有化，通过一个静态方法返回final修饰的实例对象
    缺点：类的加载可能导致对象的实例化，但是可能用不到该对象，造成内存浪费
 */
class SingleTon{
    private final static  SingleTon SINGLE_TON=new SingleTon();

    private SingleTon(){

    }
    public static SingleTon getInstance(){
        return SINGLE_TON;
    }
}