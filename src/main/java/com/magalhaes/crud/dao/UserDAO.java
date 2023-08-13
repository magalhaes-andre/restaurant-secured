package com.magalhaes.crud.dao;

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
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;

    public UserDAO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
