package com.gf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootElkApplication {

	private final static Logger logger = LoggerFactory.getLogger( SpringbootElkApplication.class );

	public static void main(String[] args) {
		SpringApplication.run(SpringbootElkApplication.class, args);
	}

	@GetMapping("/{name}")
	public String hi(@PathVariable(value = "name") String name) {
		logger.info( "name = {}" , name );
		return "hi , " + name;
	}
}
