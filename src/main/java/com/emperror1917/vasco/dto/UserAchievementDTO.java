package com.emperror1917.vasco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAchievementDTO {
    private long achievementId;
    private LocalDate achievedAt;
}
