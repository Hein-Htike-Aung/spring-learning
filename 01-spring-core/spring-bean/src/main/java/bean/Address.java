package bean;

import org.springframework.stereotype.Component;

@Component
public class Address {

    private String address = "79 Park Avenue";

    public String getAddress() {
        return address;
    }
}
