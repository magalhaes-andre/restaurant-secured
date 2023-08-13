package com.magalhaes.crud.controller;

import org.springframework.web.bind.annotation.*;

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
