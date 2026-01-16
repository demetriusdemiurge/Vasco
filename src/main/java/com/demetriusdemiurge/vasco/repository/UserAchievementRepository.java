package com.demetriusdemiurge.vasco.repository;

import com.demetriusdemiurge.vasco.dto.AchievementDto;
import com.demetriusdemiurge.vasco.dto.UnlockedAchievementDto;
import com.demetriusdemiurge.vasco.entity.Achievement;
import com.demetriusdemiurge.vasco.entity.User;
import com.demetriusdemiurge.vasco.entity.UserAchievement;
import com.demetriusdemiurge.vasco.entity.UserAchievementId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, UserAchievementId> {
    List<UserAchievement> findByUserId(Long userId);
    boolean existsByUserAndAchievement(User user, Achievement achievement);

    @Query("SELECT new com.demetriusdemiurge.vasco.dto.UnlockedAchievementDto(a.name, a.description, a.iconUrl, ua.achievedAt) FROM UserAchievement ua JOIN ua.achievement a WHERE ua.user.id = :userId")
    List<UnlockedAchievementDto> getUserUnlockedAchievements(@Param("userId") Long userId);

    @Query("""
    SELECT new com.demetriusdemiurge.vasco.dto.AchievementDto(
        a.name, a.description, a.iconUrl
    )
    FROM Achievement a
    WHERE NOT EXISTS (
        SELECT 1
        FROM UserAchievement ua
        WHERE ua.user.id = :userId
          AND ua.achievement = a
    )
""")
    List<AchievementDto> getUserLockedAchievements(@Param("userId") Long userId);

}
