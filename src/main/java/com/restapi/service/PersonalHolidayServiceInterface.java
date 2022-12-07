package com.restapi.service;

import com.restapi.model.PersonalHoliday;

public interface PersonalHolidayServiceInterface {
    PersonalHoliday addHoliday(int userId, String date, String name);
    PersonalHoliday getHoliday(int userId, String date);
    PersonalHoliday[] getHolidays(int userId);
    PersonalHoliday deleteHoliday(int userId, String date);
}
