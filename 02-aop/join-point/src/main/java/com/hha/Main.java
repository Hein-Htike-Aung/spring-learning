package com.hha;

import com.hha.beans.HelloBean;
import com.hha.beans.TransactionHistoryServiceClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

//        HelloBean helloBean = context.getBean(HelloBean.class);
//        helloBean.formatData("Xiao", "ting");
//
//        try{
//
//            helloBean.saveData(null);
//        }catch (Exception e) {
//
//        }

        context.getBean(TransactionHistoryServiceClient.class).saveTransactionData(
                "A001",
                "amount = 50",
                "private-key-3434");


    }
}
