package com.yjr.component.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/7/27
 */
public class University extends  OrgComponet{
    List<OrgComponet> collageList=new ArrayList<>();
    public University(String name, String des) {
        super(name, des);
    }

    @Override
    public void operation() {
        System.out.println(this.getName()+"下的：");
        for (OrgComponet orgComponet : collageList) {
            orgComponet.operation();
        }
    }

    @Override
    public void add(OrgComponet orgComponet) {
        collageList.add(orgComponet);
    }

    @Override
    public void remove(OrgComponet orgComponet) {
        collageList.remove(collageList);
    }
}
