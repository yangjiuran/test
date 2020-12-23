package com.yjr.Visitor;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public abstract class Person {
    protected Action action;
    protected String sex;

    public Person(Action action, String sex) {
        this.action = action;
        this.sex = sex;
    }

    public abstract void accept();
}
