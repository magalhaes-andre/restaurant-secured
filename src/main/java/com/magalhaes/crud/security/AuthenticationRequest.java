package com.magalhaes.crud.security;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthenticationRequest {

    @NotNull
    private String username;
    @NotNull
    private String password;

}
