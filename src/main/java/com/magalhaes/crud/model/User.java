package com.magalhaes.crud.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String username;
    @NotNull
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
