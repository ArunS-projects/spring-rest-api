package org.practice.controller;

import org.practice.model.User;
import org.practice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/get")
    public User getUser() {
        return new User(123, "arun", "srivastava", 32);
    }

    @GetMapping("/getUser")
    public User getUserById(){
        logger.info("fetching user data");
        Optional<User> userOpt = userService.getUserById("100000");
        logger.info("user data {}", userOpt);
        return userOpt.orElse(null);
    }

    @GetMapping("/add-user")
    public ResponseEntity<User> adduser(){
        User user  = userService.addUser();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
