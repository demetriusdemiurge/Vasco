package com.demetriusdemiurge.vasco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListOfAchievementsDto {
    List<AchievementDto> achievements;
}
