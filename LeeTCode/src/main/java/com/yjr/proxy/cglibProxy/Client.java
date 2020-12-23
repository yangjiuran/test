package com.yjr.proxy.cglibProxy;

/**
 * @author yangjiuran
 * @Date 2020/8/3
 */
public class Client {
    public static void main(String[] args) {
        TeacherClass instance  = (TeacherClass) new ProxyTeacher(new TeacherClass()).getInstance();
        instance.teach();
        System.out.println("instance hashcode"+instance.hashCode());
        System.out.println("instance tostring"+instance.toString());
        System.out.println("instance class"+instance.getClass());
    }
}
