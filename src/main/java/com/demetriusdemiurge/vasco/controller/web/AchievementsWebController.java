package com.demetriusdemiurge.vasco.controller.web;

import com.demetriusdemiurge.vasco.config.CustomUserDetails;
import com.demetriusdemiurge.vasco.service.achievement.UserAchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AchievementsWebController {

    private final UserAchievementService userAchievementService;

    @GetMapping("/achievements")
    public String achievements(Model model,
                               @AuthenticationPrincipal CustomUserDetails userDetails) {

        model.addAttribute("unlockedAchievements",
                userAchievementService.getUnlockedAchievements(userDetails.getId()));
        model.addAttribute("lockedAchievements",
                userAchievementService.getLockedAchievements(userDetails.getId()));

        return "achievements";
    }
}
