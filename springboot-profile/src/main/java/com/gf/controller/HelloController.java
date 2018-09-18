package com.gf.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value( "${server.port}" )
    private String port;

    @GetMapping("/hello")
    public String say() {
        return "hello , port is " + port;
    }

}
