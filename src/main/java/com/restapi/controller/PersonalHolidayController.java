package com.restapi.controller;

import com.restapi.model.PersonalHoliday;
import com.restapi.service.PersonalHolidayServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(("/holidays/personal"))
public class PersonalHolidayController {

    @Autowired
    PersonalHolidayServiceInterface personalHolidayService;
    @GetMapping("/{id}/isHoliday/{date}")
    boolean isHoliday(@PathVariable int id, @PathVariable String date) {
        return personalHolidayService.isHoliday(id, date);
    }

    @GetMapping("/{id}/date/{date}")
    PersonalHoliday getHoliday(@PathVariable int id, @PathVariable String date) {
        return personalHolidayService.getHoliday(id, date);
    }

    @GetMapping("/{id}/year/{year}")
    List<PersonalHoliday> getHolidays(@PathVariable int id, @PathVariable int year) {
        return personalHolidayService.getHolidays(id, year);
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    PersonalHoliday postHoliday(@PathVariable int id, @RequestBody PersonalHoliday personalHoliday) {
        return personalHolidayService.addHoliday(id, personalHoliday);
    }

    @DeleteMapping("/{id}/date/{date}")
    PersonalHoliday deleteHoliday(@PathVariable int id, @PathVariable String date) {
        return personalHolidayService.deleteHoliday(id, date);
    }
}
