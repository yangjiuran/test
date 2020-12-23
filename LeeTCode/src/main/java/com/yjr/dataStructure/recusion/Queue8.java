package com.yjr.dataStructure.recusion;

/**
 * @author yangjiuran
 * @Date 2020/10/27
 */
public class Queue8 {
    private  Integer max=8;
    private  int[] array=new int[max];

    private static int count=0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.post(0);
        System.out.println(count);
    }

    public void post(int n){
        if(n>=max){
            print();
            return;
        }
        for (Integer i = 0; i < max; i++) {
            array[n]=i;
            if(check(n)){
                post(n+1);
            }
        }
    }

    public boolean check(int n){
        for (Integer i = 0; i < n; i++) {

            if(array[n]==array[i]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    public void print(){
        count++;
        for (Integer i = 0; i < max; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
