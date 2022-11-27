package com.ajoufarmers.farmer.recommend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConditionsDto {
    private int category;
    private int size;
    private int difficulty;
    private int brightness;
    private int waterRate;
}
