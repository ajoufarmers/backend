package com.ajoufarmers.farmer.plantdictionary.service;

import com.ajoufarmers.farmer.plantdictionary.dto.PlantDto;
import com.ajoufarmers.farmer.plantdictionary.entity.Plant;
import com.ajoufarmers.farmer.plantdictionary.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlantService {
    private final PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository){
        this.plantRepository = plantRepository;
    }

    public Plant save(Plant plant){
        return plantRepository.save(plant);
    }

    public List<PlantDto> findPlants(){
        return plantRepository.findAll().stream().map(
                Plant::toDto).collect(Collectors.toList());
    }

    public Optional<PlantDto> findOne(Long plantId){
        return plantRepository.findById(plantId).map(Plant::toDto).or(Optional::empty);
    }
    public Optional<PlantDto> findOne(String plantName){
        return plantRepository.findByName(plantName).map(Plant::toDto).or(Optional::empty);
    }
}
