package com.restapi.service.implementation;

import com.restapi.model.PersonalHoliday;
import com.restapi.service.PersonalHolidayServiceInterface;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PersonalHolidayService implements PersonalHolidayServiceInterface {
    Map<Integer, PersonalHoliday> personalHolidays;

    @Override
    public PersonalHoliday addHoliday(int userId, String date, String name) {
        return null;
    }

    @Override
    public PersonalHoliday getHoliday(int userId, String date) {
        return null;
    }

    @Override
    public PersonalHoliday[] getHolidays(int userId) {
        return new PersonalHoliday[0];
    }

    @Override
    public PersonalHoliday deleteHoliday(int userId, String date) {
        return null;
    }
}
