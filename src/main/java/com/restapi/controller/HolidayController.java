package com.restapi.controller;

import java.util.List;

import com.restapi.model.Holiday;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("holidays")
public class HolidayController {
    @GetMapping("isHoliday/{countryCode}")
    boolean isHoliday(@PathVariable String countryCode, @RequestParam(required = false) String date) {
        return true;
    }

    @GetMapping("/{countryCode}/date/{date}")
    Holiday getHoliday(@PathVariable String countryCode, @PathVariable String date){
        return null;
    }
    @GetMapping("/{countryCode}/year/{year}")
    List<Holiday> getHolidays(@PathVariable String countryCode, @PathVariable String year) {
        return null;
    }
}
