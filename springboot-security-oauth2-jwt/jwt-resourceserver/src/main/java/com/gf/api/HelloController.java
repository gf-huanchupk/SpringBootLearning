package com.gf.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/api")
public class HelloController {

    @PostMapping("/api/hi")
    public String say(String name) {
        return "hi , " + name;
    }

}
