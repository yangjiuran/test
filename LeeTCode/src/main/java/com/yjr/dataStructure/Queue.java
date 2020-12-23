package com.yjr.dataStructure;

import java.util.Scanner;

/**
 * @author yangjiuran
 * @Date 2020/9/4
 */
public class Queue {
    public static void main(String[] args) {
        boolean flag=true;
        ArrayQueue queue = new ArrayQueue(3);

        while (flag){
            Scanner scanner = new Scanner(System.in);
            System.out.println("e(exit)退出程序");
            System.out.println("s(show)显示队列");
            System.out.println("p(put)添加数据");
            System.out.println("g(get)获取数据");
            char[] chars = scanner.next().toCharArray();
            try {
                switch (chars[0]){
                    case 'e':
                        flag=false;
                        break;
                    case 's':
                        queue.show();
                        break;
                    case 'p':
                        int i = scanner.nextInt();
                        queue.put(i);
                        break;
                    case 'g':
                        int val = queue.get();
                        System.out.println(val);
                        break;
                    default:break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        }

    }
    static class ArrayQueue{
        private  int[] queue;
        int rear=-1;
        int front=-1;
        int maxSize;

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            this.queue=new int[maxSize];
        }
        public void show(){
            for (int i : queue) {
                System.out.println(i);
            }
        }
        public void put(int val){
            if(!isFull()){
                rear++;
                queue[rear]=val;
            }else {
                throw new RuntimeException("队列已满");
            }
        }
        public int get(){
            if(!isEmpty()){
                front++;
                return queue[front];
            }else {
                throw new RuntimeException("队列为空");
            }
        }

        //判断队列是否空
        public Boolean isEmpty(){
            if(rear!=-1&&rear!=front){
                return false;
            }else {
                return true;
            }
        }
        //判断队列是否满
        public Boolean isFull(){
            if(rear==maxSize){
                return true;
            }else {
                return false;
            }
        }
    }

}
