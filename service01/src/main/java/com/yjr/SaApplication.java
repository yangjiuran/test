package com.yjr;

import com.yjr.constant.EnumTest;
import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author yangjiuran
 * @Date 2019/10/30
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHasor
@EnableHasorWeb
public class SaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaApplication.class,args);
    }
}
