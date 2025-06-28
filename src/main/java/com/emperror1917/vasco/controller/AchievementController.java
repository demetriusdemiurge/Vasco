package com.emperror1917.vasco.controller;

import com.emperror1917.vasco.entity.Achievement;
import com.emperror1917.vasco.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/achievements")
public class AchievementController {
    
    @Autowired
    private AchievementService achievementService;
    
    @GetMapping
    public String achievements(Model model) {
        List<Achievement> achievements = new ArrayList<>(achievementService.getAllAchievements());
        model.addAttribute("achievements", achievements);
        return "achievements";
    }
    
    @GetMapping("/progress")
    public String achievementProgress(Model model) {
        List<Achievement> achievements = new ArrayList<>(achievementService.getAllAchievements());
        model.addAttribute("achievements", achievements);
        return "achievements";
    }
    
    @GetMapping("/unlocked")
    public String unlockedAchievements(Model model) {
        List<Achievement> achievements = new ArrayList<>(achievementService.getAllAchievements());
        model.addAttribute("achievements", achievements);
        return "achievements";
    }
} 