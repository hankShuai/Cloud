package com.demo.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

//    负载均衡能力
    //@LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
