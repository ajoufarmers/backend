package com.ajoufarmers.farmer.recommend.service;

import com.ajoufarmers.farmer.plantdictionary.entity.Plant;
import com.ajoufarmers.farmer.plantdictionary.repository.PlantRepository;
import com.ajoufarmers.farmer.recommend.dto.ConditionsDto;
import com.ajoufarmers.farmer.recommend.dto.RecommendPlantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendService {
    private final PlantRepository plantRepository;

    public List<RecommendPlantDto> findByConditions(ConditionsDto conditionsDto){
        int category = conditionsDto.getCategory();
        int size = conditionsDto.getSize();
        int difficulty = conditionsDto.getDifficulty();
        int brightness = conditionsDto.getBrightness();
        int waterRate = conditionsDto.getWaterRate();

        return plantRepository.findByConditions(category, size, difficulty, brightness, waterRate)
                .stream().map(plant -> new RecommendPlantDto(plant.getId(), plant.getName(), plant.getImgUri()))
                .collect(Collectors.toList());
    }

}
