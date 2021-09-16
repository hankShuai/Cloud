package com.demo.springcloud.service;


import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFall.class)
public interface PaymentService {
    @GetMapping("/paymentSql/{id}")
    CommonResult <Payment> paymentSQL(@PathVariable("id")Long id);
}
