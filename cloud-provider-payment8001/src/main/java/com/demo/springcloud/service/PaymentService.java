package com.demo.springcloud.service;

import com.demo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param(("id"))long id);
}
