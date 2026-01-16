package com.demetriusdemiurge.vasco.service.achievement;

import com.demetriusdemiurge.vasco.dto.AchievementDto;
import com.demetriusdemiurge.vasco.dto.UnlockedAchievementDto;

import java.time.LocalDate;
import java.util.List;

public interface UserAchievementService {

    void giveAchievement(Long userId, Long achievementId, LocalDate achievedAt);

    List<UnlockedAchievementDto> getUnlockedAchievements(Long userId);

    List<AchievementDto> getLockedAchievements(Long userId);
}
