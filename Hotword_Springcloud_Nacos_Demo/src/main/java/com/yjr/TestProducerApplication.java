package com.yjr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjiuran
 * @Date 2020/1/7
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TestProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestProducerApplication.class);
    }
    @RestController
    public class TestController{
        @RequestMapping("/test/{str}")
        public String t1(@PathVariable String str){
            System.out.println("接收到消息"+str);
            return "消息发送成功："+str;
        }
    }

}
