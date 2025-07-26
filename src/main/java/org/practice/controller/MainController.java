package org.practice.controller;

import org.practice.service.CircuitBreakerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @RequestMapping("/getdata")
    public String getData() {
        logger.info("hey");
        return "test";
    }

    @RequestMapping("/getName")
    public String getName() {
        return "hello";
    }

    @RequestMapping("/testCircuitBreaker")
    public String testCircuitBreaker() {
        logger.info("hey");
        return circuitBreakerService.testCircuitBreaker();
    }

    @RequestMapping("/testCircuitBreakerAnnotation")
    public String testCircuitBreakerAnnotation() {
        logger.info("hey");
        return circuitBreakerService.testCircuitBreakerAnnotation();
    }
}