package com.emperror1917.vasco.service;

import com.emperror1917.vasco.dto.UserMarkedCountryDto;

import java.util.List;

public interface UserMarkedCountryService {

    void markCountry(Long userId, String countryIsoCode, boolean marked);
    void unmarkCountry(Long userId, String countryIsoCode);
    List<UserMarkedCountryDto> getMarkedCountries(Long userId);

}