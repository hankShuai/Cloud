package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class payController {
    static Map<Long, Payment> hashMap = new HashMap<>();
    static {


        hashMap.put(1l,new Payment(1L,"111111"));
        hashMap.put(2l,new Payment(2L,"222222"));
        hashMap.put(3l,new Payment(3L,"333333"));
    }
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> getResult(@PathVariable("id") Long id){
        if(hashMap.containsKey(id)) {
            Payment payment = hashMap.get(id);
            return new CommonResult<>(200, serverPort+"ok", payment);
        }
        return new CommonResult<>(444, "error", null);
    }

}
