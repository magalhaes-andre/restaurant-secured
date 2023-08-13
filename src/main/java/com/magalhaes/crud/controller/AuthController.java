package com.magalhaes.crud.controller;

import com.magalhaes.crud.dao.UserDAO;
import com.magalhaes.crud.security.AuthService;
import com.magalhaes.crud.security.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthService service;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/signin")
    public ResponseEntity authenticateUser(@Validated @RequestBody AuthenticationRequest authenticationRequest) {
        String token = service.attemptSignIn(authenticationRequest);
        if (token != null) {
            return ResponseEntity.ok("token: " + token);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody AuthenticationRequest auth) {
        UserDAO userDAO = service.attemptSignUp(auth);

        return ResponseEntity.ok("User registered successfully! " + userDAO.getId());
    }
}
