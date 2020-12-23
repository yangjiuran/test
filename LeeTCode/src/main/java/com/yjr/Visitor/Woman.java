package com.yjr.Visitor;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public class Woman extends Person {
    public Woman(Action action) {
        super(action,"女");
    }

    @Override
    public void accept() {
        System.out.println(this.sex+"投递了"+this.action.operation());
    }
}
