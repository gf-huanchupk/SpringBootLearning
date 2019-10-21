package com.gf;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringbootActuatorPrometheusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootActuatorPrometheusDemoApplication.class, args);
    }

    @RequestMapping(value = "/hello")
    public String  sayHello() {
        for (int i = 1 ; i <= 10 ; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } , "HelloThread - " + i);
            t.start();
        }
        return "ok";
    }

    /**
    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("application", "springboot-actuator-prometheus-demo");
    }
    */

}
