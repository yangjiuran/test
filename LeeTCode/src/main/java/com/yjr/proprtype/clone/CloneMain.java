package com.yjr.proprtype.clone;

/**
 * @author yangjiuran
 * @Date 2020/7/10
 */
public class CloneMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.name="yjr";
        student.age="25";
        student.course=new Course("语文");

        Student clone = student.clone();
        System.out.println("student.course  hashcode="+student.course.hashCode());
        System.out.println("clone.course  hashcode="+clone.course.hashCode());
    }
}
