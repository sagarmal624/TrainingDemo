package com.sagarandcompany.dockerdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Map<String, Object> sayHello() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", true);
        map.put("message", "Hello Sagar");
        return map;
    }
}
