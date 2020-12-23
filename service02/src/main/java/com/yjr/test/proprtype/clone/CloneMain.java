package com.yjr.test.proprtype.clone;

import org.springframework.beans.BeanUtils;

/**
 * @author yangjiuran
 * @Date 2020/7/10
 */
public class CloneMain {
    public static void main(String[] args) throws CloneNotSupportedException {
       /* Student student = new Student();
        student.name="yjr";
        student.age="25";
        student.course=new Course("语文");

        Student clone = student.clone();
        System.out.println("student.course  hashcode="+student.course.hashCode());
        System.out.println("clone.course  hashcode="+clone.course.hashCode());*/
        Student student = new Student();
        student.name="yjr";
        student.age="25";
        student.course=new Course("语文");
        Student clone = new Student();
        BeanUtils.copyProperties(student,clone);

        System.out.println("student.course  hashcode="+student.course.hashCode());
        System.out.println("clone.course  hashcode="+clone.course.hashCode());
    }
}
