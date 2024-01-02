package org.selenium.pom.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    public static <T> T deSerialize(String filePath,Class<T> T) throws IOException {
        InputStream inputStream = JacksonUtils.class.getClassLoader().getResourceAsStream(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream,T);
    }

}
