package com.emperror1917.vasco.service;

import com.emperror1917.vasco.entity.Achievement;
import java.util.List;
import java.util.Optional;

public interface AchievementService {
    List<Achievement> getAllAchievements();
    Optional<Achievement> getAchievementById(Long id);

    Achievement save(Achievement achievement);

    void deleteAchievement(Long id);
} 