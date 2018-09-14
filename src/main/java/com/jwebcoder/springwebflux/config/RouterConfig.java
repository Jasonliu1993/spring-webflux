package com.jwebcoder.springwebflux.config;

import com.jwebcoder.springwebflux.controller.WebFluxHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class RouterConfig {

    @Autowired
    private WebFluxHandler webFluxHandler;

    @Bean
    public RouterFunction<ServerResponse> timeRounter() {
        return RouterFunctions.route(RequestPredicates.GET("/time"), req -> webFluxHandler.getTime(req))
                .andRoute(RequestPredicates.GET("/date"), req -> webFluxHandler.getDate(req));
    }

}
