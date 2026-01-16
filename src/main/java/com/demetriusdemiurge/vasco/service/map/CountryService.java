package com.demetriusdemiurge.vasco.service.map;

import com.demetriusdemiurge.vasco.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Optional<Country> getCountryByIsoCode (Long id);

    List<Country> getAllCountries();

    void saveCountry(Country country);

    void deleteCountry(Long id);
} 