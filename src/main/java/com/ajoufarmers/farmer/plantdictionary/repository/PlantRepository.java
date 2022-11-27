package com.ajoufarmers.farmer.plantdictionary.repository;

import com.ajoufarmers.farmer.plantdictionary.entity.Plant;
import com.ajoufarmers.farmer.usermangement.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    Plant save(Plant plant);
    Optional<Plant> findByName(String name);
    Optional<Plant> findById(Long id);
    List<Plant> findAll();

    // recommend
    // 조건에 해당하는 모든 식물 불러오기
    // 1. Category, 2.Size, 3.Difficulty, 4. Brightness, 5. waterRate
    @Query("SELECT p FROM Plant p WHERE p.category = :category and p.size = :size and p.difficulty = :difficulty and p.brightness = :brightness and p.waterRate = :waterRate")
    List<Plant> findByConditions(Integer category, Integer size, Integer difficulty, Integer brightness, Integer waterRate);

}