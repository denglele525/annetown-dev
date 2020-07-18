package com.annetown.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello World!";
    }

}