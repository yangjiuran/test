package com.yjr.proxy.staticProxy;

/**
 * @author yangjiuran
 * @Date 2020/7/31
 */
public class TearcherDao implements ITearcherDao {
    @Override
    public void teach() {
        System.out.println("老师授课了~~~~");
    }
}
