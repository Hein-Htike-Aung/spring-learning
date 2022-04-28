package com.example.enviromentboot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {

    @Value("${app.default.property}")
    private String appDefaultProperty;

    @Value("${app.dev.property}")
    private String appDevProperty;

    @Value("${app.vm.property}")
    private String appVMProperty;

    public String getAppDefaultProperty() {
        return appDefaultProperty;
    }

    public String getAppDevProperty() {
        return appDevProperty;
    }

    public String getAppVMProperty() {
        return appVMProperty;
    }
}
