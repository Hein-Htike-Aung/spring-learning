package com.hha.activation.springboot.programatic.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("file")
public class FileStoreFinancialDataDao implements FinancialDataDao {
}
