package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
*@auther YangSS
*@date 2021/9/9 16:55
*/

@EnableDiscoveryClient
@SpringBootApplication
public class paymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(paymentMain8004.class,args);
    }
}
