package com.yjr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yangjiuran
 * @Date 2019/10/30
 */

@SpringBootApplication
@EnableEurekaClient
public class SbApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbApplication.class,args);
    }
}
