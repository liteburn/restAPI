package com.restapi.service;

import com.restapi.model.Holiday;

import java.util.List;

public interface HolidayServiceInterface {

    boolean isHoliday(String countryCode, String date);

    Holiday[] getHolidays(String countryCode, int year);


}
