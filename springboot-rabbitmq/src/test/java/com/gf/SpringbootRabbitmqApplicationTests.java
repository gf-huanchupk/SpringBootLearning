package com.gf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void contextLoads() {
	}

	@Test
	public void create(){
//		//创建Exchange
//		amqpAdmin.declareExchange( new DirectExchange( "exchange.direct") );
//		amqpAdmin.declareExchange( new FanoutExchange( "exchange.fanout") );
//		amqpAdmin.declareExchange( new TopicExchange( "exchange.topic") );

		//创建Queue
		amqpAdmin.declareQueue( new Queue( "direct.queue" , true ) );
		amqpAdmin.declareQueue( new Queue( "fanout.queue" , true ) );

		//绑定Queue
		amqpAdmin.declareBinding( new Binding( "direct.queue" , Binding.DestinationType.QUEUE , "exchange.direct" , "direct.queue" , null ) );
		amqpAdmin.declareBinding( new Binding( "fanout.queue" , Binding.DestinationType.QUEUE , "exchange.direct" , "fanout.queue" , null ) );
		amqpAdmin.declareBinding( new Binding( "direct.queue" , Binding.DestinationType.QUEUE , "exchange.fanout" , "" , null ) );
		amqpAdmin.declareBinding( new Binding( "fanout.queue" , Binding.DestinationType.QUEUE , "exchange.fanout" , "" , null ) );
		amqpAdmin.declareBinding( new Binding( "direct.queue" , Binding.DestinationType.QUEUE , "exchange.topic" , "direct.#" , null ) );
		amqpAdmin.declareBinding( new Binding( "fanout.queue" , Binding.DestinationType.QUEUE , "exchange.topic" , "direct.*" , null ) );


	}

	@Test
	public void send2Direct() {
		Map<String , Object> map = new HashMap<>();
		map.put( "msg" , "这是一条点对点消息" );
		map.put( "data" , Arrays.asList("helloworld" , 123 , true) );

		rabbitTemplate.convertAndSend( "exchange.direct" , "direct.queue" , map );

	}

	@Test
	public void send2Topic() {
		Map<String , Object> map = new HashMap<>();
		map.put( "msg" , "这是一条广播消息" );
		map.put( "data" , Arrays.asList("topic消息" , 123 , true) );

		rabbitTemplate.convertAndSend( "exchange.fanout" , "", map );

	}

	@Test
	public void receive() {
		Object o = rabbitTemplate.receiveAndConvert( "direct.queue" );
		o.getClass();
		System.out.println(o.getClass());
		System.out.println(o);
	}

}
