package com.ajoufarmers.farmer.plantdictionary.controller;

import com.ajoufarmers.farmer.plantdictionary.entity.Plant;
import com.ajoufarmers.farmer.plantdictionary.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlantController {
    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService){
        this.plantService = plantService;
    }

    @PostMapping("/plant/new")
    public void createPlant(@RequestParam Plant plant){
        plantService.save(plant);
    }

    @GetMapping("/plant/id")
    public ResponseEntity<?> getPlantById(@RequestParam Long id){
        return new ResponseEntity<>(plantService.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/plant/name")
    public ResponseEntity<?> getPlantByName(@RequestParam String name){
        return new ResponseEntity<>(plantService.findOne(name), HttpStatus.OK);
    }

    @GetMapping("/plant/list")
    public ResponseEntity<?> getPlantList(){
        return new ResponseEntity<>(plantService.findPlants(), HttpStatus.OK);
    }
}

