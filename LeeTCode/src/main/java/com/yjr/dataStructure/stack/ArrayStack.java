package com.yjr.dataStructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author yangjiuran
 * @Date 2020/10/14
 */
public class ArrayStack {

    public static void main(String[] args) {
        StackDemo demo = new StackDemo(5);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("show ：显示栈");
            System.out.println("push ：入栈");
            System.out.println("pop ：出栈");
            System.out.println("exit ：退出");
            switch (scanner.next()) {
                case "show":
                    demo.list();
                    break;
                case "push":
                    System.out.println("请输入要入栈的数");
                    int i = scanner.nextInt();
                    demo.push(i);
                    break;
                case "pop":
                    demo.pop();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }
}

class StackDemo {
    private int size;
    private int[] stack;
    private int top = -1;

    public StackDemo(int size) {
        this.size = size;
        stack = new int[size];
    }

    public void push(int i) {
        if (top == size - 1) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = i;
    }

    public int pop() {
        if (top < 0) {
            throw new RuntimeException("栈空");
        }
        int i = stack[top];
        System.out.printf("stack[%d]=%d，出站了 \n", i, stack[i]);
        top--;
        return i;
    }

    public void list() {
        if (top < 0) {
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n", i, stack[i]);
        }
    }
}
