package com.ajoufarmers.farmer.plantdictionary.repository;

import com.ajoufarmers.farmer.plantdictionary.entity.Plant;
import com.ajoufarmers.farmer.usermangement.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    Optional<Plant> save(Plant plant);
    Optional<Plant> findByName(String name);
    Optional<Plant> findById(Long id);
    List<Plant> findAll();
}