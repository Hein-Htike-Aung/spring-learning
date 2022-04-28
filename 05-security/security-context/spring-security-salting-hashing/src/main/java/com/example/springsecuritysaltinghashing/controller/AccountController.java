package com.example.springsecuritysaltinghashing.controller;

import com.example.springsecuritysaltinghashing.entity.RegisteringUser;
import com.example.springsecuritysaltinghashing.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class AccountController {

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/account")   // Use in Navigation
    public String account() {
        return "account";
    }

    @GetMapping("/register")  // Use in navigation
    public ModelAndView register() {
        return new ModelAndView("register", "user", new RegisteringUser());
    }

    @PostMapping("/register") // Use in templates > register
    public String register(@ModelAttribute("user") @Valid RegisteringUser user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        } else {

            // Sign up user Using JdbcUserDetailsManager
            jdbcUserDetailsManager.createUser(
                    new User(
                            user.getUsername(),
                            passwordEncoder.encode(user.getPassword()),
                            Collections.singletonList(new SimpleGrantedAuthority("USER"))
                    )
            );
            return "redirect:/login";
        }
    }

    // Add Validator at User Registration
    @InitBinder
    public void initBinder(DataBinder dataBinder) {
        dataBinder.addValidators(new UserValidator());
    }

}
