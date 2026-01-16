package com.demetriusdemiurge.vasco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UnlockedAchievementDto {
    private String name;
    private String description;
    private String iconUrl;
    private LocalDate achievedAt;
}
