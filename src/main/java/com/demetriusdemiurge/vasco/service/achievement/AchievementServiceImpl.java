package com.demetriusdemiurge.vasco.service.achievement;

import com.demetriusdemiurge.vasco.entity.Achievement;
import com.demetriusdemiurge.vasco.repository.AchievementRepository;
import com.demetriusdemiurge.vasco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Achievement> getAllAchievements() {

        return achievementRepository.findAll();
    }

    @Override
    public Optional<Achievement> getAchievementById(Long id) {

        return achievementRepository.findById(id);
    }

    @Override
    public void save(Achievement achievement) {

        achievementRepository.save(achievement);
    }

    @Override
    public void deleteAchievement(Long id) {

        achievementRepository.deleteById(id);
    }

} 