package com.yjr.component.my;

/**
 * @author yangjiuran
 * @Date 2020/7/27
 */
public abstract class OrgComponet {
    private String name;
    private String des  ;

    public void add(OrgComponet orgComponet){
        throw new  UnsupportedOperationException();
    }
    public void remove(OrgComponet orgComponet){
        throw new  UnsupportedOperationException();
    }

    public OrgComponet(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public abstract void operation();
}
