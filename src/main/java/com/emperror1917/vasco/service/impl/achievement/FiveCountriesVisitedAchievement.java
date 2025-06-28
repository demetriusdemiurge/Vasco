package com.emperror1917.vasco.service.impl.achievement;

import com.emperror1917.vasco.entity.Achievement;
import com.emperror1917.vasco.entity.User;
import com.emperror1917.vasco.repository.AchievementRepository;
import com.emperror1917.vasco.repository.UserMarkedCountryRepository;
import com.emperror1917.vasco.service.AchievementConditionChecker;
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
