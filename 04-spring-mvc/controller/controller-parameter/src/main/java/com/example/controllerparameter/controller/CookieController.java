package com.example.controllerparameter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class CookieController {


    // curl -c cookie.txt http://localhost:8080/cookie1/set-cookie
    @GetMapping("/cookie1/set-cookie")
    @ResponseBody
    public String cookie1(
            HttpServletResponse servletResponse
    ) {

        servletResponse.addCookie(new Cookie("user-id", "1345"));

        return "Setting Cookie Successfully\n";
    }

    // curl -b cookie.txt http://localhost:8080/cookie1/read-cookie
    @GetMapping("/cookie1/read-cookie")
    @ResponseBody
    public String cookie1(
            @CookieValue("user-id") String id
    ) {

        return String.format(("user-id from cookie = [%s]"), id);
    }

    // curl -c cookie.txt http://localhost:8080/cookie2/set-cookie
    @GetMapping("/cookie2/set-cookie")
    @ResponseBody
    public String cookie2(
            HttpServletResponse servletResponse
    ) {

        servletResponse.addCookie(new Cookie("user-id", "1456456"));

        return "Setting Cookie Successfully\n";
    }

    // curl -b cookie.txt http://localhost:8080/cookie2/read-cookie
    // curl http://localhost:8080/cookie2/read-cookie
    @GetMapping("/cookie2/read-cookie")
    @ResponseBody
    public String cookie2(
            @CookieValue(value = "user-id", required = false) String id
    ) {
        return String.format(("user-id from cookie = [%s]"), id);
    }

    // curl -c cookie.txt http://localhost:8080/cookie3/set-cookie
    @GetMapping("/cookie3/set-cookie")
    @ResponseBody
    public String cookie3(
            HttpServletResponse servletResponse
    ) {

        servletResponse.addCookie(new Cookie("user-id", "1567567"));

        return "Setting Cookie Successfully\n";
    }

    // curl -b cookie.txt http://localhost:8080/cookie3/read-cookie
    @GetMapping("/cookie3/read-cookie")
    @ResponseBody
    public String cookie3(
            @CookieValue("user-id") Cookie cookie
    ) {
        return String.format("cookie name = [%s], value = [%s]\n", cookie.getName(), cookie.getValue());
    }

    // curl -c cookie.txt http://localhost:8080/cookie4/set-cookie
    @GetMapping("/cookie4/set-cookie")
    @ResponseBody
    public String cookie4(
            HttpServletResponse servletResponse
    ) {

        servletResponse.addCookie(new Cookie("user-id", "124234"));

        return "Setting Cookie Successfully\n";
    }

    // curl -b cookie.txt http://localhost:8080/cookie4/read-cookie
    // curl http://localhost:8080/cookie4/read-cookie
    @GetMapping("/cookie4/read-cookie")
    @ResponseBody
    public String cookie4(
            @CookieValue(value = "user-id", required = false, defaultValue = "N/A") String id
    ) {
        return String.format(("user-id from cookie = [%s]"), id);
    }

    // curl -c cookie.txt http://localhost:8080/cookie5/set-cookie
    @GetMapping("/cookie5/set-cookie")
    @ResponseBody
    public String cookie5(
            HttpServletResponse servletResponse
    ) {

        servletResponse.addCookie(new Cookie("user-id", "1456456"));

        return "Setting Cookie Successfully\n";
    }

    // curl -c cookie.txt -b cookie.txt http://localhost:8080/cookie5/read-cookie
    // curl http://localhost:8080/cookie5/read-cookie
    @GetMapping("/cookie5/read-cookie")
    @ResponseBody
    public String cookie5(
            @CookieValue(value = "user-id", required = false) Optional<String> id
    ) {
        return String.format(("user-id from cookie = [%s]"), id.orElse("N/A"));
    }


}
