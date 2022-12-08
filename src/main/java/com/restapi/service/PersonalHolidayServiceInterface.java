package com.restapi.service;

import com.restapi.model.PersonalHoliday;
import java.util.List;

public interface PersonalHolidayServiceInterface {
    Boolean isHoliday(int userId, String date);
    PersonalHoliday addHoliday(int userId, PersonalHoliday name);
    PersonalHoliday getHoliday(int userId, String date);
    List<PersonalHoliday> getHolidays(int userId, int year);
    PersonalHoliday deleteHoliday(int userId, String date);
}
