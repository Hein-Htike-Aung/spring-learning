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
public class Otp {

    @Id
    private String username;

    private String code;

    public Otp() {
    }
}
