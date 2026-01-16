package com.demetriusdemiurge.vasco.service.map;

import com.demetriusdemiurge.vasco.dto.MarkedCountryDto;
import com.demetriusdemiurge.vasco.entity.Country;
import com.demetriusdemiurge.vasco.entity.User;
import com.demetriusdemiurge.vasco.entity.UserMarkedCountry;
import com.demetriusdemiurge.vasco.entity.UserMarkedCountryId;
import com.demetriusdemiurge.vasco.repository.CountryRepository;
import com.demetriusdemiurge.vasco.repository.UserMarkedCountryRepository;
import com.demetriusdemiurge.vasco.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<MarkedCountryDto> getMarkedCountries(Long userId) {
        List<UserMarkedCountry> markedCountries = userMarkedCountryRepository.findByUserId(userId);

        return markedCountries.stream()
                .map(entity -> new MarkedCountryDto(
                        entity.getCountry().getIsoCode(),
                        entity.isMarked()
                ))
                .collect(Collectors.toList());
    }

} 