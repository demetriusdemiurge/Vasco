package com.demetriusdemiurge.vasco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarkedCountryDto {
    private String countryIsoCode;
    private boolean marked;
}

