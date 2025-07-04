package com.emperror1917.vasco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarkedCountryDTO {
    private String countryIsoCode;
    private boolean marked;
}

