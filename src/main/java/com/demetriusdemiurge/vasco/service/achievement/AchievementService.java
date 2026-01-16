package com.demetriusdemiurge.vasco.service.achievement;

import com.demetriusdemiurge.vasco.entity.Achievement;
import java.util.List;
import java.util.Optional;

public interface AchievementService {

    List<Achievement> getAllAchievements();

    Optional<Achievement> getAchievementById(Long id);

    void save(Achievement achievement);

    void deleteAchievement(Long id);
} 