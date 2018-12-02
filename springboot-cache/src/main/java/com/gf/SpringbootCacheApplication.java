package com.gf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run( SpringbootCacheApplication.class, args);
	}
}
