package com.ajoufarmers.farmer.plantdictionary.service;

import com.ajoufarmers.farmer.plantdictionary.entity.Plant;
import com.ajoufarmers.farmer.plantdictionary.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public List<Plant> findPlants(){
        return plantRepository.findAll();
    }

    public Optional<Plant> findOne(Long plantId){
        return plantRepository.findById(plantId);
    }
    public Optional<Plant> findOne(String plantName){
        return plantRepository.findByName(plantName);
    }
}
