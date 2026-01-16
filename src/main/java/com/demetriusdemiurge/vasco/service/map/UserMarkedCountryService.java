package com.demetriusdemiurge.vasco.service.map;

import com.demetriusdemiurge.vasco.dto.MarkedCountryDto;

import java.util.List;

public interface UserMarkedCountryService {

    void markCountry(Long userId, String countryIsoCode, boolean marked);

    void unmarkCountry(Long userId, String countryIsoCode);

    List<MarkedCountryDto> getMarkedCountries(Long userId);
}