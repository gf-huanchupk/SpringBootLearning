package com.gf;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1. RabbitAutoConfiguration
 * 2. 自动配置了连接工厂ConnectionFactory
 * 3. RabbitProperties 封装了RabbitMQ的配置
 * 4. RabbitTemplate : 给RabbitMQ发送和接受消息
 * 5. AmqpAdmin : RabbitMQ系统管理功能组件
 * 6. @EnableRabbit + @RabbitListener
 */
@EnableRabbit
@SpringBootApplication
public class SpringbootRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqApplication.class, args);
	}
}
