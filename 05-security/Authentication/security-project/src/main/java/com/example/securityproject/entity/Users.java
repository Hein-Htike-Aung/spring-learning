package com.example.securityproject.entity;

import com.example.securityproject.entity.enums.EncryptionAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@ToString
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    public EncryptionAlgorithm algorithm;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Authorities> authorities = new ArrayList<>();

    public Users() {
    }
}
