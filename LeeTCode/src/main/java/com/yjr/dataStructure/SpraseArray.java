package com.yjr.dataStructure;

import java.io.*;

/**
 * @author yangjiuran
 * @Date 2020/9/3
 */
public class SpraseArray {
    public static void main(String[] args) throws IOException {
        int[][] source=new int[11][11];
        source[1][2]=1;
        source[2][3]=2;

        int sum=0;
        for (int[] ints : source) {
            for (int i : ints) {
                if(i!=0){
                    sum++;
                }
                System.out.print(i);
            }
            System.out.println();
        }
        int[][] des=new int[sum+1][3];
        //存储到稀疏数组
        System.out.println("-------------------");
        int count=0;
        des[0][0]=source.length;
        des[0][1]=source[0].length;
        des[0][2]=sum;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                if(source[i][j]!=0){
                    count++;
                    des[count][0]=i;
                    des[count][1]=j;
                    des[count][2]=source[i][j];
                }
            }
        }
        for (int[] de : des) {
            for (int i : de) {
                System.out.print("\t"+i);
            }
            System.out.println();
        }
        save(des);

        //恢复成原数组
        System.out.println("----------------------");
        int[][] recover=new int[des[0][0]][des[0][1]];
        for (int i = 1; i < des.length; i++) {
                recover[des[i][0]][des[i][1]]=des[i][2];
        }

        for (int[] ints : recover) {
            for (int anInt : ints) {
                System.out.print("\t"+anInt);
            }
            System.out.println();
        }
    }

    //将稀疏数组存储到磁盘中
    public static void save(int[][] sparse) throws IOException {
        File file = new File("I:\\Temp\\sparse.data");
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file, true);
        for (int[] ints : sparse) {
            for (int anInt : ints) {
                fw.write("\t"+anInt+"");
            }
            fw.write("\t\n");
        }
        fw.flush();
    }
}
