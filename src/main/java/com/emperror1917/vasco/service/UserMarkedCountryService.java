package com.emperror1917.vasco.service;

import com.emperror1917.vasco.dto.MarkedCountryResponse;

import java.util.List;

public interface UserMarkedCountryService {

    void markCountry(Long userID, String countryIsoCode, boolean marked);
    void unmarkCountry(Long userID, String countryIsoCode);
    List<MarkedCountryResponse> getMarkedCountries(Long userId);

}