package com.emperror1917.vasco.service.impl;

import com.emperror1917.vasco.entity.UserAchievement;
import com.emperror1917.vasco.service.UserAchievementService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class UserAchievementServiceImpl implements UserAchievementService {
    @Override
    @Transactional
    public void giveAchievement(Long userID, Long achievementId, LocalDateTime achievedAt) {

    }

    @Override
    public List<UserAchievement> getUsersAchievements(Long userId) {
        return List.of();
    }
}
