package com.xdja.bdp.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.xdja")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
