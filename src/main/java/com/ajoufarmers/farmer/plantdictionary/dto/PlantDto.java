package com.ajoufarmers.farmer.plantdictionary.dto;

import com.ajoufarmers.farmer.plantdictionary.entity.Plant;
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

    public Plant toEntity(){
        Plant plant = Plant.builder()
                .name(this.name)
                .imgUri(this.imgUri)
                .description(this.description)
                .category(this.category)
                .size(this.size)
                .difficulty(this.difficulty)
                .brightness(this.brightness)
                .waterRate(this.waterRate)
                .waterDate(this.waterDate)
                .temperature(this.temperature)
                .humidity(this.humidity)
                .waterInfo(this.waterInfo)
                .nutrition(this.nutrition)
                .harvestTime(this.harvestTime)
                .mangeInfo(this.mangeInfo).build();
        plant.setId(this.id);
        return plant;
    }
}
