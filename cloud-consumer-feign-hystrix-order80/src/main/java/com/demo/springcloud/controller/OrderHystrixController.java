package com.demo.springcloud.controller;

import com.demo.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "payment_G_FallBack")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String  result  = paymentHystrixService.paymentInfo_ok(id);
        return result;
    }
//    @HystrixCommand(fallbackMethod = "paymentInfo_to_Handler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/to/{id}")
    public String paymentInfo_to(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_to(id);
        return result;
    }
    public String paymentInfo_to_Handler(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_Ok"+id+"(ㄒoㄒ)~~";
    }
    //全局fallback 服务降级
    public String payment_G_FallBack(){
        return "global 异常";
    }
}
