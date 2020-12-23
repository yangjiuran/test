package com.yjr.controller;

import com.yjr.dao.FeginClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjiuran
 * @Date 2019/10/30
 */
@RestController
public class FeginController {
    @Autowired
    private FeginClients feginClients;
    @RequestMapping("/testA")
    public String testA(String name){
      return feginClients.getMessageFromClient(";testName:"+name);
    }
}
