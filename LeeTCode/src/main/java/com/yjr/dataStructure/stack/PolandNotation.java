package com.yjr.dataStructure.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author yangjiuran
 * @Date 2020/10/19
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> list = Arrays.asList(suffixExpression.split(" "));
        Integer cal = cal(list);
        System.out.println("cal:"+cal);
    }

    public static Integer cal(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(new Integer(s));
            } else {
                Integer num1 = new Integer(stack.pop()) ;
                Integer num2 = new Integer(stack.pop()) ;
                if ("+".equals(s)) {
                    stack.push(num2+num1);
                }else if("-".equals(s)){
                    stack.push(num2-num1);
                }else if("*".equals(s)){
                    stack.push(num2*num1);
                }else if("/".equals(s)){
                    stack.push(num2/num1);
                }
            }
        }
        return stack.pop();
    }
}

