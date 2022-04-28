package com.example.controllerparameter.controller;

import com.example.controllerparameter.ds.MutableCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class SessionAttributeController {

    /*
    * Since the test is not in browser, cookie will need
    * */
    // curl -c cookie.txt http://localhost:8080/createSessionAttribute
    @GetMapping("/createSessionAttribute")
    @ResponseBody
    public String createSessionAttribute(
            HttpServletRequest httpServletRequest
    ) {

        if (httpServletRequest.getSession().getAttribute("mutableCounterInSession") == null) {

            // set mutableCounter object into session attribute
            httpServletRequest.getSession().setAttribute("mutableCounterInSession", new MutableCounter());

        }
        return "Successfully set MutableCounter into session attribute";
    }

    // curl -b cookie.txt http://localhost:8080/readSessionAttribute
    @GetMapping("/readSessionAttribute")
    @ResponseBody
    public String readSessionAttribute(
            @SessionAttribute(name = "mutableCounterInSession") Optional<MutableCounter> mutableCounter
    ) {

        mutableCounter.get().countUp();
        return String.format("count value = [%s]", mutableCounter.get().getCount());
    }


    /*
    *
    *  Get mutableCounter instance from session where have been created in interceptor
    * */
    // curl http://localhost:8080/sessionAttribute
    @GetMapping("/sessionAttribute")
    @ResponseBody
    public String sessionAttribute(
            @SessionAttribute MutableCounter mutableCounter
    ) {
        mutableCounter.countUp();
        mutableCounter.countUp();
        return String.format("count value = [%s]", mutableCounter.getCount());
    }

    // curl http://localhost:8080/sessionAttribute2
    @GetMapping("/sessionAttribute2")
    @ResponseBody
    public String sessionAttribute2(
            @SessionAttribute(required = false, name = "current-count") Integer count
    ) {
        return String.format("count value = [%s]", count);
    }

    // curl http://localhost:8080/sessionAttribute3
    @GetMapping("/sessionAttribute3")
    @ResponseBody
    public String sessionAttribute3(
            @SessionAttribute(required = false, name = "current-count") Optional<Integer> count
    ) {
        return String.format("count value = [%s]", count.orElse(1145));
    }

}
