package com.yjr.test.proprtype.clone;

import java.io.Serializable;

/**
 * @author yangjiuran
 * @Date 2020/7/10
 */
public class Course implements Serializable{
    public String name;

    public Course(String name) {
        this.name = name;
    }
}
