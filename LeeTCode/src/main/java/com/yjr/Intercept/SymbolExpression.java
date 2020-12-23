package com.yjr.Intercept;

import java.util.Map;

/**
 * @author yangjiuran
 * @Date 2020/8/25
 */
public class SymbolExpression implements Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int intercept(Map map) {
        return 0;
    }
}
