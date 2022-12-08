package com.restapi.service;

import com.restapi.model.Holiday;

public interface HolidayServiceInterface {

    boolean isHoliday(String countryCode, String date);
    Holiday getHoliday(String countryCode, String date);

    Holiday[] getHolidays(String countryCode, int year);


}
