package com.ajoufarmers.farmer.plantdictionary.service;

import com.ajoufarmers.farmer.plantdictionary.dto.PlantDto;
import com.ajoufarmers.farmer.plantdictionary.entity.Plant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PlantServiceTest {
    @Autowired PlantService plantService;

    @Test
    void save() {
        Plant plant = Plant.builder()
                .name("콩나물")
                .category(4)
                .brightness(0)
                .description("콩나물이요")
                .difficulty(0)
                .harvestTime("7일")
                .humidity("높아야 함")
                .imgUri("콩나물 사진")
                .mangeInfo("빛 최대한 안 받게")
                .nutrition("영양성분이요")
                .size(0)
                .temperature("20도")
                .waterDate(1)
                .waterInfo("자주줘")
                .waterRate(2)
                .build();

        Plant newPlant = plantService.save(plant);
        System.out.println("Plant :" + newPlant.toString());
    }

    @Test
    void findPlants() {
        addPlants();
        System.out.println(plantService.findPlants().toString());
    }

    @Test
    void findById() {
        addPlants();
        Plant newPlant = plantService.save(Plant.builder()
                .name("양상추")
                .category(0)
                .brightness(3)
                .description("양상추요")
                .difficulty(0)
                .harvestTime("14일")
                .humidity("적당히")
                .imgUri("양상추 사진")
                .mangeInfo("빛 잘 드는 곳")
                .nutrition("양상추 영양성분이요")
                .size(1)
                .temperature("24도")
                .waterDate(5)
                .waterInfo("적당히")
                .waterRate(1)
                .build());
        Optional<PlantDto> plant = plantService.findOne(newPlant.getId());
        if(plant.isPresent())
            System.out.println(plant.toString());
        else
            System.out.println("The plant is not found by Id");
    }

    @Test
    void findByName() {
        addPlants();
        plantService.save(Plant.builder()
                .name("양상추")
                .category(0)
                .brightness(3)
                .description("양상추요")
                .difficulty(0)
                .harvestTime("14일")
                .humidity("적당히")
                .imgUri("양상추 사진")
                .mangeInfo("빛 잘 드는 곳")
                .nutrition("양상추 영양성분이요")
                .size(1)
                .temperature("24도")
                .waterDate(5)
                .waterInfo("적당히")
                .waterRate(1)
                .build());
        Optional<PlantDto> plant = plantService.findOne("양상추");
        if(plant.isPresent())
            System.out.println(plant.toString());
        else
            System.out.println("The plant is not found by name");
    }

    void addPlants(){
        plantService.save(Plant.builder()
                .name("콩나물")
                .category(4)
                .brightness(0)
                .description("콩나물이요")
                .difficulty(0)
                .harvestTime("7일")
                .humidity("높아야 함")
                .imgUri("콩나물 사진")
                .mangeInfo("빛 최대한 안 받게")
                .nutrition("영양성분이요")
                .size(0)
                .temperature("20도")
                .waterDate(1)
                .waterInfo("자주줘")
                .waterRate(2)
                .build());
        plantService.save(Plant.builder()
                .name("배추")
                .category(0)
                .brightness(3)
                .description("배추요")
                .difficulty(0)
                .harvestTime("14일")
                .humidity("적당히")
                .imgUri("배추 사진")
                .mangeInfo("빛 잘 드는 곳")
                .nutrition("배추 영양성분이요")
                .size(1)
                .temperature("24도")
                .waterDate(5)
                .waterInfo("적당히")
                .waterRate(1)
                .build());
    }
}