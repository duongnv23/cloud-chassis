package com.duongnv.chassis.business;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping("/")
public class GreetingController {
    @GetMapping("/greeting/{name}")
    public Mono<String> greeting(@PathVariable String name) {
        return Mono.just(String.format("Greeting %s @ %s", name, Instant.now()));
    }

    @GetMapping("/delay/{second}")
    public Mono<String> delay(@PathVariable int second) {
        return Mono
                .delay(Duration.ofSeconds(second))
                .map(s -> String.format("Greeting @ %s after %s second(s)", Instant.now(), second))
                ;
    }
}
