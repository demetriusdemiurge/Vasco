package com.emperror1917.vasco.service;

import com.emperror1917.vasco.entity.Achievement;
import com.emperror1917.vasco.entity.User;
import java.util.Optional;

public interface AchievementConditionChecker {
    Optional<Achievement> check(User user);
}
