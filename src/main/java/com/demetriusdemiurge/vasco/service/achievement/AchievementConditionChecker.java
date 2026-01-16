package com.demetriusdemiurge.vasco.service.achievement;

import com.demetriusdemiurge.vasco.entity.Achievement;
import com.demetriusdemiurge.vasco.entity.User;
import java.util.Optional;

public interface AchievementConditionChecker {
    Optional<Achievement> check(User user);
}
