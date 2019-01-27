package com.gf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ScEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run( ScEurekaServerApplication.class, args );
    }

}

