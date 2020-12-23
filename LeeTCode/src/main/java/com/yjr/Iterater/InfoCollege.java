package com.yjr.Iterater;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public class InfoCollege implements College {
    List<Department> departments;
    int numOfDepartment=0;


    @Override
    public String getName() {
        return "信息工程学院";
    }

    public InfoCollege() {
        departments=new ArrayList<>();
        addDepartMent("网络工程","网络工程专业");
        addDepartMent("计算机科学与技术","计算机科学与技术专业");

    }

    @Override
    public void addDepartMent(String name, String desc) {
        departments.add(new Department(name,desc));
        numOfDepartment+=1;
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departments);
    }
}
