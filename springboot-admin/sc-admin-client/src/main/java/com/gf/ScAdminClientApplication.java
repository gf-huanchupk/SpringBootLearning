package com.gf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ScAdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run( ScAdminClientApplication.class, args );
    }

}

