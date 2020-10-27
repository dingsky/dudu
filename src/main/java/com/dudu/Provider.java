package com.dudu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class Provider {
    public static void main(String[] args){
        SpringApplication.run(Provider.class, args);
    }

    @RestController
    public class ProviderController {
        @GetMapping("/hello/{name}")
        public String hello(@PathVariable String name) {
            return "Hello spring clound discover:" + name;
        }
    }
}
