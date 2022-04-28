package com.hha;

import com.hha.beans.SpringBean6;
import com.hha.beans.SpringBean7;
import com.hha.beans.SpringBean8;
import org.springframework.context.annotation.*;

import javax.swing.*;

@ComponentScan//(lazyInit = true)
@Configuration
//@Lazy (All Beans in AppConfig will be Lazy)
public class AppConfig {

    // Singleton (default)
    @Bean
    public SpringBean7 springBean7() {
        return new SpringBean7();
    }

    @Bean
    @Lazy
    public SpringBean8 springBean8() {
        return new SpringBean8();
    }

//    @Bean
//    @Scope("prototype")
//    public SpringBean8 springBean8() {
//        return new SpringBean8();
//    }

}
