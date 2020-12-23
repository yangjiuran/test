package com.yjr.proxy.staticProxy;

/**
 * @author yangjiuran
 * @Date 2020/7/31
 */
public class Client {
    public static void main(String[] args) {
        TearcherDao tearcherDao = new TearcherDao();
        TearcherProxy proxy = new TearcherProxy(tearcherDao);
        proxy.teach();

    }
}
