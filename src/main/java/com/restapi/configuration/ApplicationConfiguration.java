package com.restapi.configuration;


import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
public class ApplicationConfiguration {
    @Value("${holidays-url}")
    public static String HOLIDAYS_URL;
}
