package com.hha.beans;

import com.hha.annotations.Sanitize;
import org.springframework.stereotype.Component;

@Component
public class TransactionHistoryServiceClient {

    public void saveTransactionData(String identifier, String data, @Sanitize String privateKey) {

        System.out.println(
                String.format(
                        "Sending data -> identifier = [%s] data = [%s] privateKey = [%s]",
                        identifier, data, privateKey
                )
        );
    }
}
