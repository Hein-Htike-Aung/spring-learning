package com.example.controllerparameter.controller;

import com.example.controllerparameter.dao.AddressDao;
import com.example.controllerparameter.ds.Address;
import com.example.controllerparameter.ds.Country;
import com.example.controllerparameter.ds.Person;
import com.example.controllerparameter.ds.ShortAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({
        "person", "shortAddress", "country"
})
public class SessionAttributesController {

    @Autowired
    private AddressDao addressDao;


    @ModelAttribute("person")
    public Person person() {
        return new Person();
    }

    @ModelAttribute("shortAddress")
    public ShortAddress shortAddress() {
        return new ShortAddress();
    }

    @ModelAttribute("country")
    public Country country() {
        return new Country();
    }

    /*
    *     Address List
    * */
    // localhost:8080/sessionAttributes01  (In browser)
    @GetMapping("/sessionAttributes01")
    public String sessionAttributes01(
            Model model
    ) {
        model.addAttribute("addresses", addressDao.findAll());
        return "address-list";
    }

    /*
    *    Person
    * */
    @GetMapping("/sessionAttributes02/person")
    public String sessionAttributes02(
            Person person
    ) {
        return "sessionAttributes02-person";
    }

    @PostMapping("/sessionAttributes02/person")
    public String sessionAttributes03(
            Person person,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            return "sessionAttributes02-person";
        } else {

            return "redirect:/sessionAttributes02/shortAddress";
        }
    }

    /*
     *    Short Address
     * */
    @GetMapping("/sessionAttributes02/shortAddress")
    public String sessionAttributes04(
            Person person,
            ShortAddress shortAddress
    ) {

        return "sessionAttributes02-shortAddress";
    }

    @PostMapping("/sessionAttributes02/shortAddress")
    public String sessionAttributes05(
            ShortAddress shortAddress,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            return "sessionAttributes02-address";
        } else {

            return "redirect:/sessionAttributes02/country";
        }
    }

    /*
     *    Country
     * */
    @GetMapping("/sessionAttributes02/country")
    public String sessionAttributes06(
            Person person,
            ShortAddress shortAddress,
            Country country
    ) {

        return "sessionAttributes02-country";
    }

    @PostMapping("/sessionAttributes02/country")
    public String sessionAttributes06(
            Person person,
            ShortAddress shortAddress,
            Country country,
            BindingResult bindingResult,
            SessionStatus sessionStatus
    ) {

        if (bindingResult.hasErrors()) {
            return "sessionAttributes02-country";
        } else {

            Address address = new Address(person, shortAddress, country);
            addressDao.save(address);

            sessionStatus.setComplete();
            return "redirect:/sessionAttributes01";
        }
    }

}
