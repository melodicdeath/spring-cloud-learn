package com.heynemo.microservicesimpleprovideruser.controller;


import com.heynemo.microservicesimpleprovideruser.entity.User;
import com.heynemo.microservicesimpleprovideruser.repository.UserRepository;
import com.netflix.appinfo.EurekaInstanceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;
    @Value("${server.port}")
    private int serverPort = 0;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        log.info("{}:{},{}",eurekaInstanceConfig.getInstanceId(), eurekaInstanceConfig.getHostName(false),serverPort);
        return this.userRepository.findById(id);
    }
}