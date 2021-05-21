package com.buddhi.multiplelibrary.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackMethodController {

    @RequestMapping("/serviceFallBack")
    public Mono<String> serviceFallBack() {
        return Mono.just("service is taking too long to respond or is down. Please try again later");
    }
}
