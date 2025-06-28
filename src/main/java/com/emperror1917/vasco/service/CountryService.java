package com.emperror1917.vasco.service;

import com.emperror1917.vasco.entity.Country;

import java.util.List;

public interface CountryService {
    Country getCountryById(Long id);
    List<Country> getAllCountries();

    void saveCountry(Country country);

    void deleteCountry(Long id);
} 