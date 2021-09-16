package com.demo.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    //正常访问
    public String paymentInfo(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_Ok"+id+"(*^_^*)";
    }
    @HystrixCommand(fallbackMethod = "paymentInfo_to_Handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String Timeout(Integer id){
        try{TimeUnit.SECONDS.sleep(3);}catch (InterruptedException e){e.printStackTrace();};
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_Ok"+id+"耗时3s";
    }
    public String paymentInfo_to_Handler(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_Ok"+id+"(ㄒoㄒ)~~";
    }

    //服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true")
    })
    public  String paymentcircuitBreaker(@PathVariable("id")Integer id){

        if(id<0){
            throw new RuntimeException("id  负数");
        }
        String seriNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"流水号"+seriNum;

    }
    public  String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，稍后再试"+id;
    }
}
