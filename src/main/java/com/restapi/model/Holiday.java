package com.restapi.model;

import lombok.Data;

@Data
public class Holiday {
    String countryCode;
    String date;
    String localName;
    String name;
}
