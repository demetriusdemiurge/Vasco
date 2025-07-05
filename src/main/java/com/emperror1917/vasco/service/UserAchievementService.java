package com.emperror1917.vasco.service;

import com.emperror1917.vasco.dto.UserAchievementDTO;

import java.time.LocalDate;
import java.util.List;

public interface UserAchievementService {

    void giveAchievement(Long userID, Long achievementId, LocalDate achievedAt);
    List<UserAchievementDTO> getUsersAchievements(Long userId);

}
