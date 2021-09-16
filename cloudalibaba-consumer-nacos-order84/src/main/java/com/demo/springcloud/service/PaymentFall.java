package com.demo.springcloud.service;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFall implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级--paymentFail",new Payment(id,"error"));
    }
}
