package com.yjr.Visitor;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public class Success implements Action {
    @Override
    public String operation() {
        return "成功票";
    }
}
