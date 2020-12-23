package com.yjr.controller;

import com.yjr.Service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjiuran
 * @Date 2019/10/30
 */
@RestController
public class controllerA {
    @Autowired
    private ServiceB serviceB;
    @RequestMapping("/test")
    public String test(String name){
        return serviceB.testB()+name;
    }
}
