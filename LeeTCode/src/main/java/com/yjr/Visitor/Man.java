package com.yjr.Visitor;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public class Man extends Person {
    public Man(Action action) {
        super(action, "男");
    }

    @Override
    public void accept() {
        System.out.println(this.sex+"投递了"+this.action.operation());
    }
}
