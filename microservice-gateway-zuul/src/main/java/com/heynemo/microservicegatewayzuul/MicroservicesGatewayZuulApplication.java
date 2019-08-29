package com.heynemo.microservicegatewayzuul;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.stream.Stream;


@EnableZuulProxy
@SpringBootApplication
public class MicroservicesGatewayZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroservicesGatewayZuulApplication.class, args);
    }
}
