package com.emperror1917.vasco.service.impl;

import com.emperror1917.vasco.dto.MarkedCountryDTO;
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

    @Override
    @Transactional
    public void markCountry(Long userId, String countryIsoCode, boolean marked) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Country country = countryRepository.findByIsoCode(countryIsoCode)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        UserMarkedCountryId userMarkedCountryId = new UserMarkedCountryId();
        userMarkedCountryId.setUserId(user.getId());
        userMarkedCountryId.setCountryIsoCode(country.getIsoCode());

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
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Country country = countryRepository.findByIsoCode(countryIsoCode)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        UserMarkedCountryId userMarkedCountryId = new UserMarkedCountryId();
        userMarkedCountryId.setUserId(user.getId());
        userMarkedCountryId.setCountryIsoCode(country.getIsoCode());

        userMarkedCountryRepository.deleteById(userMarkedCountryId);
    }

    public List<MarkedCountryDTO> getMarkedCountries(Long userId) {
        List<UserMarkedCountry> marked = userMarkedCountryRepository.findByUserId(userId);

        return marked.stream()
                .map(entity -> new MarkedCountryDTO(
                        entity.getCountry().getIsoCode(),
                        entity.isMarked()
                ))
                .toList();
    }

} 