package com.example.authserverdemo01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Data
@ToString
@Entity
public class User {

    @Id
    private String username;

    private String password;

    public User() {
    }
}
