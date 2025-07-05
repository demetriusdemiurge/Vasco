package com.emperror1917.vasco.repository;

import com.emperror1917.vasco.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, UserAchievementId> {
    List<UserAchievement> findByUserId(Long userId);
    boolean existsByUserAndAchievement(User user, Achievement achievement);
}
