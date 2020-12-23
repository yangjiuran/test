package com.yjr.dataStructure.recusion;

import com.yjr.Visitor.Fail;

/**
 * @author yangjiuran
 * @Date 2020/10/21
 */
public class FindWay {
    public static void main(String[] args) {
        int[][] map=new int[8][7];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[0][j]=1;
                map[7][j]=1;
            }
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        map[3][3]=1;
        map[3][4]=1;
        map[3][5]=1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        getWay(map,1,1);
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 2->可以通行 3->已经走过无法通行  0->表示未探测
     * 下->右->左->上
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean getWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else {
            if(map[i][j]==0){
                map[i][j]=2;
                if(getWay(map,i,j-1)){
                    return true;
                }else if(getWay(map,i-1,j)){
                    return true;
                }else if(getWay(map,i+1,j)){
                    return true;
                }else if(getWay(map,i,j+1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
