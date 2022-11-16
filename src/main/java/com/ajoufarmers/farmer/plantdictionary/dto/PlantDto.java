package com.ajoufarmers.farmer.plantdictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PlantDto {
    private Long id;
    private String name;
    private String imgUri;
    private String description;
    private int category;
    private int size;
    private int difficulty;
    private int brightness;
    private int waterRate;
    private int waterDate;
    private String temperature;
    private String humidity;
    private String waterInfo;
    private String nutrition;
    private String harvestTime;
    private String mangeInfo;
}
