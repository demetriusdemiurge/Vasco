package com.emperror1917.vasco.service;

import com.emperror1917.vasco.dto.UserAchievementDto;

import java.time.LocalDate;
import java.util.List;

public interface UserAchievementService {

    void giveAchievement(Long userID, Long achievementId, LocalDate achievedAt);
    List<UserAchievementDto> getUsersAchievements(Long userId);

}
