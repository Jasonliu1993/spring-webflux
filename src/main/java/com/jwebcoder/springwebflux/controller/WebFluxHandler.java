package com.jwebcoder.springwebflux.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

@Component
public class WebFluxHandler {

    public String getSimpleDateFormat(String pattern) {
        Function<String, SimpleDateFormat> formatFunction = SimpleDateFormat::new;
        return formatFunction.apply(pattern).format(new Date());
    }

    public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("currentTime:" + getSimpleDateFormat("HH:mm:ss")), String.class);
    }

    public Mono<ServerResponse> getDate(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("currentDate:" + getSimpleDateFormat("yyyy-MM-dd")), String.class);
    }

}
