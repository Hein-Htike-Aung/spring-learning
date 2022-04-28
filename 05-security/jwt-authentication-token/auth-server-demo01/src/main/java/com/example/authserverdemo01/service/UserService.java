package com.example.authserverdemo01.service;

import com.example.authserverdemo01.entity.Otp;
import com.example.authserverdemo01.entity.User;
import com.example.authserverdemo01.repository.OtpRepository;
import com.example.authserverdemo01.repository.UserRepository;
import com.example.authserverdemo01.utils.GenerateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void add(User user) {

        // Encode User's Password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    // Check Authentication and Renew/Update User's Otp
    public void auth(User user) {

        Optional<User> userOptional = userRepository.findUserByUsername(user.getUsername());

        // check username
        if (userOptional.isPresent()) {

            User storedUser = userOptional.get();

            // check password
            if (passwordEncoder.matches(user.getPassword(), storedUser.getPassword())) {

                // Renew Otp
                renewOtp(storedUser);
            } else {
                throw new BadCredentialsException("Username and Password are not matched.");
            }

        } else {
            throw new BadCredentialsException("Username doesn't exist.");
        }
    }

    public boolean checkOtp(Otp otpToValidate) {

        Optional<Otp> optionalOtp = otpRepository.findOtpByUsername(otpToValidate.getUsername());

        if (optionalOtp.isPresent()) {
            if (otpToValidate.getCode().equals(optionalOtp.get().getCode())) {

                return true;
            }
        }
        return false;
    }

    private void renewOtp(User user) {
        String newCode = GenerateCodeUtil.generateCode();

        // Find Otp code by username
        Optional<Otp> otpOptional = otpRepository.findOtpByUsername(user.getUsername());

        if (otpOptional.isPresent()) {

            // For existential User
            Otp otp = otpOptional.get();
            otp.setCode(newCode);

        } else {

            // For New User
            Otp otp = new Otp();
            otp.setUsername(user.getUsername());
            otp.setCode(newCode);

            otpRepository.save(otp);
        }
    }

}
