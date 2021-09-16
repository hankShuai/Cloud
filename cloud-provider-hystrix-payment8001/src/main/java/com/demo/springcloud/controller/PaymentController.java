package com.demo.springcloud.controller;

import com.demo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value(value = "${server.port}")
    private String serverPort;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
       String result = paymentService.paymentInfo(id);
        log.info("#######################################################"+result);
        return result;
    }


    @GetMapping("/payment/hystrix/to/{id}")
    public String paymentInfo_to(@PathVariable("id") Integer id){
        String result = paymentService.Timeout(id);
        log.info("#######################################################"+result);
        return result;
    }

}
