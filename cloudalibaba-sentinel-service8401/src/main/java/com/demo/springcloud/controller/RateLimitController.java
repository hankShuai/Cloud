package com.demo.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import com.demo.springcloud.myHandller.mBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "资源限流ok", new Payment(2020L, "serial"));

    }

    public CommonResult handleException(BlockException block) {
        return new CommonResult(444, block.getClass().getName(), "\t服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl",
            blockHandlerClass =mBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult byURL() {
        return new CommonResult(200, "url资源限流ok", new Payment(2020L, "serial"));

    }
}
