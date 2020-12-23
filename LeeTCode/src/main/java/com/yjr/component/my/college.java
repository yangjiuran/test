package com.yjr.component.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/7/27
 */
public class college extends  OrgComponet{
    List<OrgComponet> departmentList=new ArrayList<>();
    public college(String name, String des) {
        super(name, des);
    }

    @Override
    public void operation() {
        System.out.println(this.getName()+"下的");
        for (OrgComponet department : departmentList) {
            department.operation();
        }
    }

    @Override
    public void add(OrgComponet orgComponet) {
        departmentList.add(orgComponet);
    }

    @Override
    public void remove(OrgComponet orgComponet) {
        departmentList.remove(orgComponet);
    }
}
