package com.yjr.Iterater;

import java.util.Iterator;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public interface College {

    String getName();

    void addDepartMent(String name ,String desc);

    Iterator createIterator();
}
