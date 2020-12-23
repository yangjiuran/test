package com.yjr.dataStructure.find;

/**
 * @author yangjiuran
 * @Date 2020/11/12
 */
public class InsertValueFind {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 5 ,6, 7, 8, 9};
        int i = find(arr, 0, arr.length-1, 9);
        System.out.println(i);

    }
    public static int find(int[] arr,int left,int right,int findVal){
        System.out.println("a hhhhhh");
        if(left>right||findVal<left||findVal>right){
            return -1;
        }
        int mid=left+(right-left)*((findVal-arr[left])/(arr[right]-arr[left]));
        int midVal=arr[mid];
        if(midVal>findVal){
            return find(arr,left,mid-1,findVal);
        }else if(midVal<findVal){
            return find(arr,mid+1,right,findVal);
        }else {
            return mid;
        }
    }
}
