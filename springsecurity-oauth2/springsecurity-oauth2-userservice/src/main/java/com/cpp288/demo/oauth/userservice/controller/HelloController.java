package com.cpp288.demo.oauth.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello
 *
 * @author chenjian
 * @date 2021/1/13 上午11:48
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
