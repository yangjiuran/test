package com.yjr.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yangjiuran
 * @Date 2020/8/3
 */
public class ProxyTeacher implements MethodInterceptor{
    private Object target;

    public ProxyTeacher(Object target) {
        this.target = target;
    }

    public Object getInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TeacherClass.class);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getDeclaringClass()!=Object.class&&method.getName()=="teach"&&method.getReturnType()==String.class){
            System.out.println("cglib proxy is start~~~");
            System.out.println("cglib proxy is end~~~");
        }
        Object invoke = method.invoke(target, objects);
        return invoke;
    }
}
