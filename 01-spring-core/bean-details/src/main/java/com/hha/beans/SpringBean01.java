package com.hha.beans;

import com.sun.jdi.VoidValue;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringBean01 {

    private final SpringBean02 springBean02;

    private final SpringBean03 springBean03;

    public SpringBean01(SpringBean02 springBean02, SpringBean03 springBean03) {
        this.springBean02 = springBean02;
        this.springBean03 = springBean03;
    }

    public void printDependencies() {
        System.out.println("");
        System.out.println(springBean02.getClass().getSimpleName());
        System.out.println(springBean03.getClass().getSimpleName());

        springBean03.printHash();

    }

    private void init() {
        System.out.println(getClass().getSimpleName() + "::init()");
    }
}
