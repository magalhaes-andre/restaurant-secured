package com.magalhaes.crud.controller;

import com.magalhaes.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {


    @GetMapping
    public String testResource() {
        return "ih, deu certo";
    }
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
//
//    @GetMapping
//    public List<User> fetchAllUsers() {
//        return userService.fetchAllUsers();
//    }
}
