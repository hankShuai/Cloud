package com.demo.springcloud.controller;

import com.demo.springcloud.domain.CommonResult;
import com.demo.springcloud.domain.Order;
import com.demo.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.createOrder(order);
        return new CommonResult(200,"订单创建成功");
    }
}
