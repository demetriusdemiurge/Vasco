package com.demetriusdemiurge.vasco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AchievementDto {
    private String name;
    private String description;
    private String iconUrl;
}
