package com.yjr.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangjiuran
 * @Date 2019/10/30
 */
@Component
@FeignClient(value = "serviceb")
public interface FeginClients {
    @RequestMapping("/test")
    String getMessageFromClient(@RequestParam(value = "name")String name);
}
