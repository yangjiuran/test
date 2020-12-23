package com.yjr.responseChain;

import com.yjr.Visitor.Man;

/**
 * @author yangjiuran
 * @Date 2020/9/1
 */
public abstract class Manager {
    private Manager nextManager;
    private String name;


    public Manager(String name) {
        this.name = name;
    }

    public void setNextManager(Manager nextManager) {
        this.nextManager = nextManager;
    }

    public String getName() {
        return name;
    }

    public Manager getNextManager() {
        return nextManager;
    }

    public abstract void process(MyRequest request);

}
