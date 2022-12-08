package com.restapi.model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
public class PersonalHoliday {
    Integer userId;
    String date;

    @EqualsAndHashCode.Exclude
    String name;
}
