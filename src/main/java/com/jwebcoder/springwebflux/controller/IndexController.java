package com.jwebcoder.springwebflux.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public Mono<String> index() {
        return Mono.just("Hello World");
    }

}
