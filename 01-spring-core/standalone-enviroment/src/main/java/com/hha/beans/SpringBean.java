package com.hha.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {

    @Value("${app.file.property}")
    private String appFileProperty;

    @Value("${app.vm.property}")
    private String appVMProperty;

    @Value("${JAVA_HOME}")
    private String javaHome;

    public String getAppFileProperty() {
        return appFileProperty;
    }

    public String getAppVMProperty() {
        return appVMProperty;
    }

    public String getJavaHome() {
        return javaHome;
    }

}
