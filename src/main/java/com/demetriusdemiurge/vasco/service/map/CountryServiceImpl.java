package com.demetriusdemiurge.vasco.service.map;

import com.demetriusdemiurge.vasco.entity.Country;
import com.demetriusdemiurge.vasco.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {

        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryByIsoCode(Long id) {

        return countryRepository.findById(id);
    }

    @Override
    public void saveCountry(Country country) {

        countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long id) {

        countryRepository.deleteById(id);
    }
} 