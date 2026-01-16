package com.demetriusdemiurge.vasco.controller.api;

import com.demetriusdemiurge.vasco.config.CustomUserDetails;
import com.demetriusdemiurge.vasco.dto.AchievementDto;
import com.demetriusdemiurge.vasco.dto.UnlockedAchievementDto;
import com.demetriusdemiurge.vasco.service.achievement.AchievementService;
import com.demetriusdemiurge.vasco.service.achievement.UserAchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AchievementsApiController {

    private final UserAchievementService userAchievementService;

    @GetMapping("/unlocked-achievements")
    public ResponseEntity<List<UnlockedAchievementDto>> getUnlockedAchievements(
            @AuthenticationPrincipal CustomUserDetails userDetails) {

        List<UnlockedAchievementDto> unlockedAchievements = userAchievementService.getUnlockedAchievements(userDetails.getId());

        return ResponseEntity.ok(unlockedAchievements);
    }

    @GetMapping("/locked-achievements")
    public ResponseEntity<List<AchievementDto>> getLockedAchievements(
            @AuthenticationPrincipal CustomUserDetails userDetails) {

        List<AchievementDto> lockedAchievements = userAchievementService.getLockedAchievements(userDetails.getId());

        return ResponseEntity.ok(lockedAchievements);

    }

//    @PostMapping("/give-achievement")
//    public ResponseEntity<Void> giveAchievement(@RequestBody UnlockedAchievementDto request,
//                                            @AuthenticationPrincipal CustomUserDetails userDetails) {
//        userAchievementService.giveAchievement(userDetails.getId(), request.getId(), request.getAchievedAt());
//        return ResponseEntity.ok().build();
//        return null;
//    }

}
