package com.yjr.component.my;

/**
 * @author yangjiuran
 * @Date 2020/7/27
 */
public class Department extends  OrgComponet{
    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public void operation() {
        System.out.println(this.getName());
    }
}
