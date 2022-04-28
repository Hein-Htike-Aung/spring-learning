package com.example.authserverdemo01.repository;

import com.example.authserverdemo01.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<Otp, String> {


    Optional<Otp> findOtpByUsername(String username);
}
