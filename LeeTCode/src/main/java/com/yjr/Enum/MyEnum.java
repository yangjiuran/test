package com.yjr.Enum;

/**
 * @author yangjiuran
 * @Date 2020/6/29
 */
public enum  MyEnum {
    ONE("111"),TOW("222");
    public String value;
    private MyEnum(String s){
        this.value=s;
    }
}
