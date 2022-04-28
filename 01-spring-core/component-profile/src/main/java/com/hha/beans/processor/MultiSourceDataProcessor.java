package com.hha.beans.processor;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"database", "file"})
public class MultiSourceDataProcessor implements DataProcessor{
}
