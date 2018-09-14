package com.gf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 来标注一个主程序，说明是一个Spring Boot 应用
 */
@SpringBootApplication
public class SpringbootFirstApplication {

	public static void main(String[] args) {
		//Spring 应用启动起来
		SpringApplication.run(SpringbootFirstApplication.class, args);
	}
}
