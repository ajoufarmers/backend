package com.ajoufarmers.farmer.plantdictionary.entity;

import com.ajoufarmers.farmer.plantdictionary.dto.PlantDto;
import com.ajoufarmers.farmer.usermangement.dto.MemberDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false)
    private String imgUri;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int category;
    @Column(nullable = false)
    private int size;
    @Column(nullable = false)
    private int difficulty;
    @Column(nullable = false)
    private int brightness;
    @Column(nullable = false)
    private int waterRate;
    @Column(nullable = false)
    private int waterDate;
    @Column(nullable = false)
    private String temperature;
    @Column(nullable = false)
    private String humidity;
    @Column(nullable = false)
    private String waterInfo;
    @Column(nullable = false)
    private String nutrition;
    @Column(nullable = false)
    private String harvestTime;
    @Column(nullable = false)
    private String mangeInfo;

    @Builder
    public Plant(String name, String imgUri, String description, int category, int size, int difficulty,
                 int brightness, int waterRate, int waterDate, String temperature, String humidity, String waterInfo,
                 String nutrition, String harvestTime, String mangeInfo){
        this.name = name;
        this.imgUri = imgUri;
        this.description = description;
        this.category = category;
        this.size = size;
        this.difficulty = difficulty;
        this.brightness = brightness;
        this.waterRate = waterRate;
        this.waterDate = waterDate;
        this.temperature = temperature;
        this.humidity = humidity;
        this.waterInfo = waterInfo;
        this.nutrition = nutrition;
        this.harvestTime = harvestTime;
        this.mangeInfo = mangeInfo;
    }

    public PlantDto toDto(){
        return PlantDto.builder()
                .id(this.id)
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
                .mangeInfo(this.mangeInfo)
                .build();
    }
}
