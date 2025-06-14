package org.practice.controller;

import org.practice.interceptors.MyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    @RequestMapping("/getdata")
    public String getData(){
        logger.info("hey");
        return "test";
    }
}