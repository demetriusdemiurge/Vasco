package com.demetriusdemiurge.vasco.service.achievement;

import com.demetriusdemiurge.vasco.dto.AchievementDto;
import com.demetriusdemiurge.vasco.dto.UnlockedAchievementDto;
import com.demetriusdemiurge.vasco.entity.Achievement;
import com.demetriusdemiurge.vasco.entity.User;
import com.demetriusdemiurge.vasco.entity.UserAchievement;
import com.demetriusdemiurge.vasco.entity.UserAchievementId;
import com.demetriusdemiurge.vasco.repository.AchievementRepository;
import com.demetriusdemiurge.vasco.repository.UserAchievementRepository;
import com.demetriusdemiurge.vasco.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAchievementServiceImpl implements UserAchievementService {

    private final UserAchievementRepository userAchievementRepository;
    private final UserRepository userRepository;
    private final AchievementRepository achievementRepository;

    private User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private Achievement getAchievement(Long achievementId) {
        return achievementRepository.findById(achievementId)
                .orElseThrow(() -> new RuntimeException("Achievement not found"));
    }

    @Override
    @Transactional
    public void giveAchievement(Long userId, Long achievementId, LocalDate achievedAt) {

        User user = getUser(userId);
        Achievement achievement = getAchievement(achievementId);
        UserAchievementId userAchievementId = new UserAchievementId();
        userAchievementId.setUserId(userId);
        userAchievementId.setAchievementId(achievementId);

        UserAchievement userAchievement = userAchievementRepository.findById(userAchievementId)
                .orElse(new UserAchievement());

        userAchievement.setUserAchievementId(userAchievementId);
        userAchievement.setUser(user);
        userAchievement.setAchievement(achievement);
        userAchievement.setAchievedAt(achievedAt);

        userAchievementRepository.save(userAchievement);

    }

    @Override
    public List<UnlockedAchievementDto> getUnlockedAchievements(Long userId) {

        return userAchievementRepository.getUserUnlockedAchievements(userId);
    }

    @Override
    public List<AchievementDto> getLockedAchievements(Long userId) {

        return userAchievementRepository.getUserLockedAchievements(userId);
    }
}
