package com.demo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${server.port}")
    private String  serverPort;

    @Value("${config.info")
    private String  configInfo;

    @GetMapping("/configInfo")
    public String ConfigInfo(){
        return "server" +serverPort+"\t\n\n"+"info"+configInfo;
    }
}
