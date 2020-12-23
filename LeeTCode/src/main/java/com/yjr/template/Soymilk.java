package com.yjr.template;

/**
 * @author yangjiuran
 * @Date 2020/8/3
 */
public abstract class Soymilk {
    public final void make(){
        select();
        if(flag()) add();
        grind();
    }

    private void select(){
        System.out.println("选择黄豆");
    }
    protected abstract void add();

    private void grind(){
        System.out.println("开始研磨");
    }

    protected Boolean flag(){
        return true;
    }
}
