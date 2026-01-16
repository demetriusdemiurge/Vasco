package com.demetriusdemiurge.vasco.service.achievement;

import com.demetriusdemiurge.vasco.entity.Achievement;
import com.demetriusdemiurge.vasco.entity.User;
import com.demetriusdemiurge.vasco.repository.AchievementRepository;
import com.demetriusdemiurge.vasco.repository.UserMarkedCountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FiveCountriesVisitedAchievement implements AchievementConditionChecker {

    private final AchievementRepository achievementRepository;
    private final UserMarkedCountryRepository userMarkedCountryRepository;

    @Override
    public Optional<Achievement> check(User user) {
        int count = userMarkedCountryRepository.countByUserAndMarkedTrue(user);
        if (count >= 5) {
            return achievementRepository.findByName("Novice traveler");
        }
        return Optional.empty();
    }
}
