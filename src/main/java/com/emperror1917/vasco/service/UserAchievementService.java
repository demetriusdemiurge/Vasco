package com.emperror1917.vasco.service;

import com.emperror1917.vasco.entity.UserAchievement;

import java.time.LocalDateTime;
import java.util.List;

public interface UserAchievementService {

    void giveAchievement(Long userID, Long achievementId, LocalDateTime achievedAt);
    List<UserAchievement> getUsersAchievements(Long userId);

}
