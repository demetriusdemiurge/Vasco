package com.emperror1917.vasco.service.impl;

import com.emperror1917.vasco.dto.UserAchievementDto;
import com.emperror1917.vasco.entity.Achievement;
import com.emperror1917.vasco.entity.User;
import com.emperror1917.vasco.entity.UserAchievement;
import com.emperror1917.vasco.entity.UserAchievementId;
import com.emperror1917.vasco.repository.AchievementRepository;
import com.emperror1917.vasco.repository.UserAchievementRepository;
import com.emperror1917.vasco.repository.UserRepository;
import com.emperror1917.vasco.service.UserAchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<UserAchievementDto> getUsersAchievements(Long userId) {

        List<UserAchievement> userAchievements = userAchievementRepository.findByUserId(userId);

        return userAchievements.stream()
                .map(entity -> new UserAchievementDto(
                        entity.getAchievement().getId(),
                        entity.getAchievedAt()
                ))
                .collect(Collectors.toList());
    }
}
