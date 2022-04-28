package com.hha.beans.reader;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("file")
public class FileDataReader implements DataReader{
}
