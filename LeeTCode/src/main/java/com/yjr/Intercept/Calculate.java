package com.yjr.Intercept;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author yangjiuran
 * @Date 2020/8/25
 */
public class Calculate {

    private Expression expression;

    public Calculate(String expStr) {
        Stack<Expression> stacks = new Stack<>();
        char[] exp = expStr.toCharArray();
        Expression left = null;
        Expression right = null;
        for (int i = 0; i < exp.length; i++) {
            switch (exp[i]) {
                case '+':
//                    stacks.pop();
                    left = stacks.pop();
                    right = new VarExpression(exp[++i] + "");
                    stacks.push(new AddSymbolExpression(left, right));
                    break;
                case '-':
//                    stacks.pop();
                    left = stacks.pop();
                    right = new VarExpression(exp[++i] + "");
                    stacks.push(new SubSymbolExpression(left, right));
                    break;
                default:
                    stacks.push(new VarExpression(String.valueOf(exp[i])));
                    break;
            }
        }
        this.expression=stacks.pop();
    }

    public int run(Map map){
        return this.expression.intercept(map);
    }
}
