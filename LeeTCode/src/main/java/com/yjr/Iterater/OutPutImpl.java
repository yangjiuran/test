package com.yjr.Iterater;

import java.util.Iterator;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public class OutPutImpl {
    List<College> list;

    public OutPutImpl(List<College> list) {
        this.list = list;
    }
    public void print(){
        Iterator<College> iterator = list.iterator();
        while (iterator.hasNext()){
            College college = iterator.next();
            System.out.println("++++++++"+college.getName()+"+++++++++");
            printDept(college.createIterator());
        }
    }
    public void  printDept(Iterator iterator){
        while (iterator.hasNext()){
           Department dept = (Department) iterator.next();
            System.out.println(dept.getName());
        }
    }
}
