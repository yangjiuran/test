package com.yjr.dataStructure.stack;

import com.sun.media.sound.UlawCodec;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author yangjiuran
 * @Date 2020/10/14
 */
public class ArrayStackCalDemo {

    public static void main(String[] args) {
        String expression = "400-200";
        StackDemoCal<Integer> numStack = new StackDemoCal<>(10);
        StackDemoCal<String> operStack = new StackDemoCal<>(10);

        int num1;
        int num2;
        Integer pushNum= null;
        String oper;
        int index=0;
        while (true) {
            oper = expression.substring(index, index + 1);
            if(isOper(oper)){
                //如果是一个符号，判断栈是否为空
                if(operStack.isEmpty()){
                    //为空直接入栈
                    operStack.push(oper);
                }else {
                    //判断优先级，如果栈顶优先级小，则弹出并运算
                    if(priority(oper)<priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        String popOper = operStack.pop();
                        numStack.push(cal(num1,num2,popOper));
                        operStack.push(oper);
                    }else {
                        operStack.push(oper);
                    }
                }
            }else {
                //如果是一个数字,直接入栈
                if(index+1<expression.length()){
                    //下一个是数字
                    if(!isOper(expression.substring(index+1, index + 2))){
                        if (pushNum!=null){
                            pushNum=new Integer(pushNum+oper);
                        }else {
                            pushNum=new Integer(oper);
                        }
//                        numStack.push(pushNum);
                        index++;
                        continue;
                    }else {
                        if (pushNum!=null){
//                            Integer pop = numStack.pop();
                            Integer pop=new Integer(pushNum+""+oper)  ;
                            numStack.push(new Integer(pop));
                            pushNum=null;
                        }else {
                            numStack.push(new Integer(oper));
                        }
                    }
                }else {
                    numStack.push(new Integer(oper));
                }

            }
            index++;
            if(index>=expression.length()){
                break;
            }
        }
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper= operStack.pop();
            int cal = cal(num1, num2, oper);
            numStack.push(cal);
        }
        System.out.printf(expression+"= %d",numStack.peek());
    }


    /**
     * 判断操作符的优先级
     */
    public static int priority(String oper) {
        if ("+".equals(oper) || "-".equals(oper)) {
            return 0;
        } else if ("*".equals(oper) || "/".equals(oper)) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否是一个操作符
     */
    public static boolean isOper(String oper) {
        if ("+".equals(oper) || "-".equals(oper) || "*".equals(oper) || "/".equals(oper)) {
            return true;
        }
        return false;
    }

    /**
     * 运算
     */
    public static int cal(int num1,int num2,String oper){
        switch (oper){
            case "+":
                return num2+num1;
            case "-":
                return num2-num1;
            case "*":
                return num2*num1;
            case "/":
                return num2/num1;
            default:
                break;
        }
        return 0;
    }

}
class StackDemoCal<T extends Object> {
    private int size;
    private T[] stack;
    private int top = -1;

    /**
     * 查看栈顶的数据
     */
    public T peek() {
        return stack[top];
    }

    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }
    public StackDemoCal(int size) {
        this.size = size;
        stack = (T[]) new Object[size];
    }

    public void push(T i) {
        if (top == size - 1) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = i;
    }

    public T pop() {
        if (top < 0) {
            throw new RuntimeException("栈空");
        }
        T i = stack[top];
//        System.out.printf("stack[%d]=%d，出站了 \n", i, stack[top]);
        top--;
        return i;
    }

    public void list() {
        if (top < 0) {
            return;
        }
        for (int i = top; i >= 0; i--) {
//            System.out.printf("stack[%d]=%d \n", i, stack[i]);
        }
    }
}
