package com.restapi.service.implementation.commons;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeExtractor {
    public static Integer extractYear(String date) {
        try {
            return Integer.valueOf(date.split("-")[0]);
        } catch (Exception e) {
            log.info("User tried wrong date - " + date);
            throw e;
        }
    }
}
