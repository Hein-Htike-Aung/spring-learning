package com.hha.beans;

public class SpringBean02 {

    private void destroy() {
        System.out.println(getClass().getSimpleName() + "::destroy()");
    }
}
