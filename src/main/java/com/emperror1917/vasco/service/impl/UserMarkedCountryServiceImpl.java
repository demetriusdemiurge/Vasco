package com.emperror1917.vasco.service.impl;

import com.emperror1917.vasco.dto.UserMarkedCountryDTO;
import com.emperror1917.vasco.entity.Country;
import com.emperror1917.vasco.entity.User;
import com.emperror1917.vasco.entity.UserMarkedCountry;
import com.emperror1917.vasco.entity.UserMarkedCountryId;
import com.emperror1917.vasco.repository.CountryRepository;
import com.emperror1917.vasco.repository.UserMarkedCountryRepository;
import com.emperror1917.vasco.repository.UserRepository;
import com.emperror1917.vasco.service.UserMarkedCountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMarkedCountryServiceImpl implements UserMarkedCountryService {

    private final UserMarkedCountryRepository userMarkedCountryRepository;
    private final UserRepository userRepository;
    private final CountryRepository countryRepository;

    private User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private Country getCountry(String countryIsoCode) {
        return countryRepository.findByIsoCode(countryIsoCode)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    @Override
    @Transactional
    public void markCountry(Long userId, String countryIsoCode, boolean marked) {

        User user = getUser(userId);
        Country country = getCountry(countryIsoCode);
        UserMarkedCountryId userMarkedCountryId = new UserMarkedCountryId();
        userMarkedCountryId.setUserId(userId);
        userMarkedCountryId.setCountryIsoCode(countryIsoCode);

        UserMarkedCountry userMarkedCountry = userMarkedCountryRepository.findById(userMarkedCountryId)
                .orElse(new UserMarkedCountry());

        userMarkedCountry.setId(userMarkedCountryId);
        userMarkedCountry.setUser(user);
        userMarkedCountry.setCountry(country);
        userMarkedCountry.setMarked(marked);

        userMarkedCountryRepository.save(userMarkedCountry);
    }

    @Override
    @Transactional
    public void unmarkCountry(Long userId, String countryIsoCode) {

        User user = getUser(userId);
        Country country = getCountry(countryIsoCode);

        UserMarkedCountryId userMarkedCountryId = new UserMarkedCountryId();
        userMarkedCountryId.setUserId(user.getId());
        userMarkedCountryId.setCountryIsoCode(country.getIsoCode());

        userMarkedCountryRepository.deleteById(userMarkedCountryId);
    }

    public List<UserMarkedCountryDTO> getMarkedCountries(Long userId) {
        List<UserMarkedCountry> markedCountries = userMarkedCountryRepository.findByUserId(userId);

        return markedCountries.stream()
                .map(entity -> new UserMarkedCountryDTO(
                        entity.getCountry().getIsoCode(),
                        entity.isMarked()
                ))
                .toList();
    }

} 