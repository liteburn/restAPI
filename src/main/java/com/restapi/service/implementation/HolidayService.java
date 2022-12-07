package com.restapi.service.implementation;

import com.google.gson.Gson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.model.Holiday;
import com.restapi.service.HolidayServiceInterface;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import static com.restapi.configuration.ApplicationConfiguration.HOLIDAYS_URL;

@Service
@Slf4j
public class HolidayService implements HolidayServiceInterface {
    @Autowired
    private CloseableHttpClient httpClient;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public boolean isHoliday(String countryCode, String date) {
        Holiday[] holidays = getHolidays(countryCode, extractYear(date));
        for (Holiday holiday: holidays) {
            if (holiday.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Holiday[] getHolidays(String countryCode, int year) {
        ResponseEntity<Holiday[]> holidays = restTemplate.getForEntity(HOLIDAYS_URL + "/" + countryCode + "/" + year,
                Holiday[].class);
        return holidays.getBody();
    }

    private Holiday[] getHolidays(String countryCode, String date) {
        ResponseEntity<Holiday[]> holidays = restTemplate.getForEntity(HOLIDAYS_URL + "/" + countryCode + "/" + extractYear(date),
                                                    Holiday[].class);
        return holidays.getBody();
    }
    private String extractYear(String date){
        try{
            return date.split("-")[0];
        } catch (Exception e) {
            log.info("User tried wrong date - " + date);
            throw e;
        }
    }
}
