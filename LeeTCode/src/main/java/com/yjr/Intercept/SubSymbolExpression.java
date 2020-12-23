package com.yjr.Intercept;

import java.util.Map;

/**
 * @author yangjiuran
 * @Date 2020/8/25
 */
public class SubSymbolExpression extends SymbolExpression {

    public SubSymbolExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int intercept(Map map) {
        return super.left.intercept(map)-super.right.intercept(map);
    }
}
