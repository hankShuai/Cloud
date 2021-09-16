package com.demo.springcloud.controller;

import com.demo.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMsgController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendmsg")
    public String sendMsg(){
        return iMessageProvider.send();
    }

}
