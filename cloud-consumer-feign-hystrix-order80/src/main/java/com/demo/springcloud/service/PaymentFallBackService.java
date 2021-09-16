package com.demo.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements  PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "---Payment fall back_ok--";
    }

    @Override
    public String paymentInfo_to(Integer id) {
        return "---Payment fall back_to--";
    }
}
