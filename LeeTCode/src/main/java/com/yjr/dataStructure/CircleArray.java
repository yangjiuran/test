package com.yjr.dataStructure;

import java.util.Scanner;

/**
 * @author yangjiuran
 * @Date 2020/9/15
 */
public class CircleArray {
    public static void main(String[] args) {
        boolean flag=true;
        CircleQueue queue = new CircleQueue(3);

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
   static class CircleQueue{
        int[] queue;
        int rear=0;
        int front=0;
        int maxSize;

        public CircleQueue(int maxSize) {
            this.maxSize = maxSize;
            this.queue=new int[maxSize];
        }

        public boolean isEmpty(){
            if(rear==front){
                return true;
            }else {
                return false;
            }
        }
        public boolean isFull(){
            if((rear+1+maxSize)%maxSize==front){
                return true;
            }else {
                return false;
            }
        }
        public int size(){
            return (rear+maxSize-front)%maxSize;
        }

        public void put(int value){
            if(isFull()){
                throw new RuntimeException("队列已满");
            }else {
                queue[rear]=value;
                rear=(rear+1)%maxSize;
            }
        }
        public int get(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }else {
                int val=queue[front];
                front=(front+1)%maxSize;
                return val;
            }
        }

        public void show(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }
            for (int i = front; i < front+size(); i++) {
                System.out.printf("arr[%d]=%d\n",i%maxSize,queue[i%maxSize]);
            }
        }
    }
}
