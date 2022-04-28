package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    @Autowired
    private Address personAddress;

    private String name = "Xiaoting";

    public String getName() {
        return name;
    }

    public String getPersonInfo() {
        return name + " " + personAddress.getAddress();
    }

}
