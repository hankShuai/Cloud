package com.demo.springcloud.service;

import com.demo.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    //CommonResult<Payment> getPaymentById(@Param(("id"))long id);
    @GetMapping("/payment/get/{id}")
     CommonResult getPaymentById(@PathVariable("id")Long id);
}
