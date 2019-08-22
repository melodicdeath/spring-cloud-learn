package com.heynemo.microserviceconsumermovie.controller;

import com.heynemo.microserviceconsumermovie.UserFeignClient;
import com.heynemo.microserviceconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RequestMapping("/movies")
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
        User user = this.restTemplate.getForObject(
                "http://microservice-simple-provider-user/users/{id}",
                User.class,
                id
        );
        // ...电影微服务的业务...
        return user;
    }

    @GetMapping("/users2/{id}")
    public User findById2(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }
}
