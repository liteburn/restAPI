package com.restapi.controller;

import com.restapi.model.Holiday;
import com.restapi.service.implementation.HolidayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidayController {

    @Autowired HolidayService holidayService;

    @GetMapping("{countryCode}/isHoliday/{date}")
    Boolean isHoliday(@PathVariable String countryCode, @PathVariable(required = false) String date) {
        System.out.println(date);
        return holidayService.isHoliday(countryCode, date);
    }

    @GetMapping("/{countryCode}/date/{date}")
    Holiday getHoliday(@PathVariable String countryCode, @PathVariable String date) {
        return holidayService.getHoliday(countryCode, date);
    }

    @GetMapping("/{countryCode}/year/{year}")
    Holiday[] getHolidays(@PathVariable String countryCode, @PathVariable String year) {
        return holidayService.getHolidays(countryCode, Integer.parseInt(year));
    }
}
