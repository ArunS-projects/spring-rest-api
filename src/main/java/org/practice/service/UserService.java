package org.practice.service;

import org.practice.model.User;
import org.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(){
        return userRepository.addUser();
    }

    public Optional<User> getUserById(String id){
        return userRepository.findById(id);
    }
}
