package com.yjr.Iterater;



import java.util.Iterator;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public class ComputerCollege implements College {
    Department[] departments;
    int numOfDepartment=0;


    @Override
    public String getName() {
        return "计算机学院";
    }

    public ComputerCollege() {
        departments=new Department[5];
        addDepartMent("Java","java专业");
        addDepartMent("Php","php专业");
        addDepartMent("C++","C++专业");
        addDepartMent("Pytho","Python专业");
    }

    @Override
    public void addDepartMent(String name, String desc) {
        departments[numOfDepartment]=new Department(name,desc);
        numOfDepartment+=1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
