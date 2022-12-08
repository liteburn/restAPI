package com.restapi.service.implementation;

import com.restapi.model.Holiday;
import com.restapi.service.HolidayServiceInterface;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

import static com.restapi.configuration.ApplicationConfiguration.HOLIDAYS_URL;
import static com.restapi.service.implementation.commons.TimeExtractor.extractYear;

@Service
@Slf4j
public class HolidayService implements HolidayServiceInterface {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public boolean isHoliday(String countryCode, String date) {
        return getHoliday(countryCode, date) != null;
    }

    @Override
    public Holiday getHoliday(String countryCode, String date) {
        Holiday[] holidays = getHolidays(countryCode, extractYear(date));

        for (Holiday holiday : holidays) {
            if (holiday.getDate().equals(date)) {
                return holiday;
            }
        }
        return null;
    }

    @Override
    public Holiday[] getHolidays(String countryCode, int year) {
        log.info(HOLIDAYS_URL + "/" + year + "/" + countryCode);
        ResponseEntity<Holiday[]> holidays = restTemplate.getForEntity(HOLIDAYS_URL + "/" + year + "/" + countryCode,
                Holiday[].class);

        return holidays.getBody();
    }
}
