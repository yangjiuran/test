package com.yjr.Iterater;


import java.util.Iterator;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public class InfoCollegeIterator implements Iterator {
    List<Department> departments;
    int position=-1;

    public InfoCollegeIterator(List<Department> departments) {
        this.departments=departments;
    }

    @Override
    public boolean hasNext() {
        if(position>=departments.size()-1){
            return false;
        }else {
            position+=1;
            return true;
        }
    }

    @Override
    public Department next() {
        Department department = departments.get(position);
        return department;
    }
}
