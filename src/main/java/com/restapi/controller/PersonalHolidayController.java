package com.restapi.controller;

import com.restapi.model.Holiday;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("holidays/personal")
public class PersonalHolidayController {
    @GetMapping("/{id}")
    boolean isHoliday(@PathVariable int id, @RequestParam String date) {
        return true;
    }

    @GetMapping("/{id}/{year}")
    List<Holiday> getHolidays(@PathVariable int id, @PathVariable String year) {
        return null;
    }

    @PostMapping("/{id}")
    Holiday postHoliday(@PathVariable int id, @RequestParam String date, @RequestParam String name) {
        return null;
    }

    @DeleteMapping("/{id}")
    Holiday deleteHoliday(@PathVariable int id, @RequestParam String date, @RequestParam String name) {
        return null;
    }
}
