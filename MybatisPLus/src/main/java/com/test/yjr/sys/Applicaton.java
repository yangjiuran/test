package com.test.yjr.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yangjiuran
 * @Date 2019/10/20
 */
@SpringBootApplication
//@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
@ComponentScan(basePackages = "com.test.yjr.sys")
public class Applicaton {
        public static void main(String[] args) {
            SpringApplication.run(Applicaton.class, args);
        }

}
