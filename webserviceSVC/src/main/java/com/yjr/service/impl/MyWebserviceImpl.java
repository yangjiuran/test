package com.yjr.service.impl;/**
 * @author yangjiuran
 * @Date 2021/3/30
 */

import com.yjr.service.MyWebService;

/**
 * @ClassName MyWebserviceImpl
 * @Description
 * @Author Administrator
 * @Date 2021/3/30 14:30
 * @Version 1.0
 */
public class MyWebserviceImpl implements MyWebService {
    @Override
    public String hello(String str) {
        return "hello,"+str;
    }
}
