package com.gf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.gf" , exclude = DataSourceAutoConfiguration.class)
public class SbmStorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbmStorageServiceApplication.class, args);
    }

}
