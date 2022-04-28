package com.example.businesslogicserver.authentication.proxy;

import com.example.businesslogicserver.authentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationServerProxy {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${auth.server.base.url}")
    private String baseUrl;

    // send to check Auth to AuthServer
    public void sendAuth(String username, String password) {

        // username and password came from url

//         /user/auth means check authentication and Add/Update User's Otp in Auth Server
        String url = baseUrl + "/user/auth";

        var body = new User();
        body.setUsername(username);
        body.setPassword(password);

        var request = new HttpEntity<>(body);

        System.out.println("check");
        restTemplate.postForEntity(url, request, Void.class);

    }

    // send username and otp code to AuthServer
    public boolean sendOTP(String username, String code) {

        // username and code came for url

//        /otp/check means check Otp code
        String url = baseUrl + "/otp/check";

        var body = new User();
        body.setUsername(username);
        body.setCode(code);

        var request = new HttpEntity<>(body);

        // /otp/check has response
        var response = restTemplate.postForEntity(url, request, Void.class);

        return response.getStatusCode().equals(HttpStatus.OK);

    }
}
