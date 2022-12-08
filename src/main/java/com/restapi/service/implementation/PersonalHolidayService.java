package com.restapi.service.implementation;

import com.restapi.model.PersonalHoliday;
import com.restapi.service.PersonalHolidayServiceInterface;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import static com.restapi.service.implementation.commons.TimeExtractor.extractYear;

@Service
public class PersonalHolidayService implements PersonalHolidayServiceInterface {

    Map<HolidayUniqueParams, PersonalHoliday> personalHolidays = new HashMap<>();
    Set<PersonalHoliday> holidays = new HashSet<>();

    @Override
    public Boolean isHoliday(int userId, String date) {
        return getHoliday(userId, date) != null;
    }

    @Override
    public PersonalHoliday addHoliday(int userId, PersonalHoliday personalHoliday) {
        if (holidays.contains(personalHoliday)) {
            return null;
        }
        holidays.add(personalHoliday);
        personalHolidays.put(new HolidayUniqueParams(userId, personalHoliday.getDate()), personalHoliday);
        return personalHoliday;
    }

    @Override
    public PersonalHoliday getHoliday(int userId, String date) {
        HolidayUniqueParams uniqueParams = new HolidayUniqueParams(userId, date);
        if (personalHolidays.containsKey(uniqueParams)) {
            return personalHolidays.get(uniqueParams);
        }
        return null;
    }

    @Override
    public List<PersonalHoliday> getHolidays(int userId, int year) {
        List<PersonalHoliday> userHolidays = new ArrayList<>();
        for (HolidayUniqueParams params : personalHolidays.keySet()) {
            if ((params.getUserId() == userId) && (extractYear(params.getDate()) == year)) {
                userHolidays.add(personalHolidays.get(params));
            }
        }

        return userHolidays;
    }

    @Override
    public PersonalHoliday deleteHoliday(int userId, String date) {
        HolidayUniqueParams uniqueParams = new HolidayUniqueParams(userId, date);
        if (personalHolidays.containsKey(uniqueParams)) {
            return personalHolidays.remove(uniqueParams);
        }
        return null;
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    @Getter
    private static class HolidayUniqueParams {

        int userId;
        String date;
    }

}

