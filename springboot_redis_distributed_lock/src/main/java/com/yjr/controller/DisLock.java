package com.yjr.controller;/**
 * @author yangjiuran
 * @Date 2021/5/28
 */

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DisLock
 * @Description
 * @Author Administrator
 * @Date 2021/5/28 14:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/dis_lock")
public class DisLock {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    /***
    * @Description 在对资源进行操作时先在尝试在redis用setnx加锁，加锁成功则操作资源，失败则不不能操作资源
     * 存在的问题
     *      1.如果加锁过后程序中断或者物理机宕机造成finally中的代码无法执行则会造成死锁
    * @return {@link }
    * @throws
    * @author yjr
    * @date 2021/5/28 14:25
    */
    @RequestMapping("/lock1")
    public void lock1(){
        String lock_name="lock";
        String num="num";
        //从redis中读取库存数量
        Integer o = (Integer) redisTemplate.opsForValue().get(num);
        //加锁操作，如果redis中有该键则加锁失败，没有该键才能加锁成功
        Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent(lock_name, "1");
        if(!ifAbsent){
            //加锁失败要么等待，要么直接返回
            return;
        }
        //加锁成功才进行业务操作
        try {
            //减库存
            o=o-1;
            redisTemplate.opsForValue().set(num,o);
            System.out.println("当前的库存为"+o);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放锁
            redisTemplate.delete(lock_name);
        }

    }

    /***
    * @Description
     *  redisTemplate.opsForValue().setIfAbsent(lock_name, "1",30, TimeUnit.SECONDS);
     *  此时对锁的超时间进行了限制，但是这个超时时间的限制完全是基于业务的评估，有可能在流量洪峰的时候由于业务时间的的加长造成锁提前释放
    * @param
    * @return {@link }
    * @throws
    * @author yjr
    * @date 2021/5/28 17:02
    */
    @RequestMapping("/lock2")
    public void lock2(){
        String lock_name="lock";
        String num="num";

        //加锁操作，如果redis中有该键则加锁失败，没有该键才能加锁成功,在加锁时设置锁的超时时间这样就不会造成代码终止造成的死锁
        Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent(lock_name, "1",30, TimeUnit.SECONDS);
        //从redis中读取库存数量
        Integer o = (Integer) redisTemplate.opsForValue().get(num);
        if(!ifAbsent){
            //加锁失败要么等待，要么直接返回
            return;
        }
        //加锁成功才进行业务操作
        try {
            //减库存
            o=o-1;
            redisTemplate.opsForValue().set(num,o);
            System.out.println("当前的库存为"+o);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放锁
            redisTemplate.delete(lock_name);
        }

    }
    @Autowired
    RedissonClient redissonClient;
    @RequestMapping("/lock3")
    public void lock3(){
        /*String lock_name="lock";
        String num="num";

        //加锁操作，如果redis中有该键则加锁失败，没有该键才能加锁成功,在加锁时设置锁的超时时间这样就不会造成代码终止造成的死锁
//        Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent(lock_name, "1",30, TimeUnit.SECONDS);
        redissonClient.getLock(lock_name);
        //从redis中读取库存数量
        Integer o = (Integer) redisTemplate.opsForValue().get(num);
        if(!ifAbsent){
            //加锁失败要么等待，要么直接返回
            return;
        }
        //加锁成功才进行业务操作
        try {
            //减库存
            o=o-1;
            redisTemplate.opsForValue().set(num,o);
            System.out.println("当前的库存为"+o);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放锁
            redisTemplate.delete(lock_name);
        }*/

    }
}
