package com.magalhaes.crud.security;

import com.magalhaes.crud.model.User;
import com.magalhaes.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenHandler tokenHandler;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepository repository;

    public String attemptSignIn(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenHandler.generateJwtToken(authentication);

        return token;
    }

    public User attemptSignUp(AuthenticationRequest request) {
        User user = new User(request.getUsername(),
                encoder.encode(request.getPassword()));
        return repository.save(user);
    }
}
