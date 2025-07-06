package com.emperror1917.vasco.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/achievements")
public class AchievementsWebController {

    @GetMapping
    public String achievements() {
        return "achievements";
    }
} 