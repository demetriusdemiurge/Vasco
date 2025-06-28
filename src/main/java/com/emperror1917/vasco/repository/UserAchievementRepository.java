package com.emperror1917.vasco.repository;

import com.emperror1917.vasco.entity.Achievement;
import com.emperror1917.vasco.entity.User;
import com.emperror1917.vasco.entity.UserAchievement;
import com.emperror1917.vasco.entity.UserAchievementId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, UserAchievementId> {
    boolean existsByUserAndAchievement(User user, Achievement achievement);
}
