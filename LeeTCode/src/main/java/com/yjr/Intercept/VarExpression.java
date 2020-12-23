package com.yjr.Intercept;

import java.util.Map;

/**
 * @author yangjiuran
 * @Date 2020/8/25
 */
public class VarExpression implements Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int intercept(Map map) {
        return Integer.valueOf((String) map.get(this.key));
    }
}
