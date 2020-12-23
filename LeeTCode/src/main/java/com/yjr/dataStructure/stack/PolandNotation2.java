package com.yjr.dataStructure.stack;

import com.yjr.obeserver.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yangjiuran
 * @Date 2020/10/19
 */
public class PolandNotation2 {
    public static void main(String[] args) {
     /*   String suffixExpression = "3 4 + 5 * 6 -";
        List<String> list = Arrays.asList(suffixExpression.split(" "));
        Integer cal = cal(list);
        System.out.println("cal:"+cal);*/
        String midExpression = "1+((2+3)*4)-5";

        List list = strToList(midExpression);
        System.out.println(list);
        List list1 = suffixExpressionToList(list);
        System.out.println(list1);
        Integer cal = cal(list1);
        System.out.println(cal);
    }

    public static List suffixExpressionToList(List<String> list){
        Stack<String> s1 = new Stack<>();
        List<String> l2 = new ArrayList<>();
        for (String s : list) {
            if(s.matches("\\d+")){
                l2.add(s);
            }else if("(".equals(s)){
                //‘(’ 直接入栈
                s1.push(s);
            }else if(")".equals(s)){
                while (!"(".equals(s1.peek())){
                    l2.add(s1.pop()) ;
                }
                s1.pop();
            }else {
                if(s1.isEmpty()||rank(s)>rank(s1.peek())){
                    //如果入栈元素 大于 栈顶元素 直接入栈
                    s1.push(s);
                }else {
                    //如果入栈元素 小于 栈顶元素 则弹出栈顶元素，将栈顶元素放入到数栈;反复比较栈顶元素，知道遇到 （ 或者遇到
                    //优先级比入栈元素小的栈顶元素
                    while (s1.size()!=0&&rank(s)<=rank(s1.peek())){
                        l2.add(s1.pop());
                    }
                    s1.push(s);
                }
            }
        }
        while (s1.size()!=0){
            l2.add(s1.pop());
        }
        return l2;
    }
    public static List strToList(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        String s = "";
        do {
            if ((str.charAt(i)) < 48 || (str.charAt(i)) > 57) {
                list.add(str.charAt(i) + "");
                i++;
            } else {
                s = "";
                while (i < str.length() && (str.charAt(i)) >= 48 && (str.charAt(i)) <= 57) {
                    s += str.charAt(i);
                    i++;
                }
                list.add(s);
            }
        } while (i < str.length());
        return list;
    }

    public static Integer cal(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(new Integer(s));
            } else {
                Integer num1 = new Integer(stack.pop());
                Integer num2 = new Integer(stack.pop());
                if ("+".equals(s)) {
                    stack.push(num2 + num1);
                } else if ("-".equals(s)) {
                    stack.push(num2 - num1);
                } else if ("*".equals(s)) {
                    stack.push(num2 * num1);
                } else if ("/".equals(s)) {
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }

    private static int SUB = 1;
    private static int ADD = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    private static int rank(String s) {
        int result = 0;
        switch (s) {
            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MUL;
            case "/":
                return DIV;
            default:
                return result;
        }
    }
}

