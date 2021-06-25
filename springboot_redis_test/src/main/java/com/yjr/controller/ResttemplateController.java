package com.yjr.controller;/**
 * @author yangjiuran
 * @Date 2021/6/17
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @ClassName ResttemplateController
 * @Description
 * @Author Administrator
 * @Date 2021/6/17 7:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/redisTest")
public class ResttemplateController {
    @Autowired
    private RedisTemplate redisTemplate;
    String uid="yjr";
    @GetMapping("/test")
    public String testRedis(){
        redisTemplate.opsForValue().set("name","yjr");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
        return name;
    }
    @GetMapping("/secKill")
    public void secKill(){
        String userId=uid+new Random(999999).nextInt();
        //1构建商品库存的key 和已经参与秒杀用户的userKey
        String prodKey="sk:prod";
        String userKey="us:user";
        //2根据商品的key获取redis中的库存
        Integer countprod  = (Integer) redisTemplate.opsForValue().get("balance");
        //3根据userKey获取已参加秒杀的用户
        Boolean member = redisTemplate.opsForSet().isMember(userKey, userId);
        //判断库存>=0时才能秒杀
        //userKey中不包含用户uid的用户才能参加秒杀
        if(!member){
            if(countprod>=0){
                //库存-1
                redisTemplate.opsForValue().decrement(prodKey);
                //将uid加入到userkey
                redisTemplate.opsForSet().add(userKey,userId);
                System.out.println(userId+"秒杀完成");
            }
            else {
                System.out.println("秒杀结束");
            }
        }else {
            System.out.println(userId+"已经参加过了");
        }
    }
}
