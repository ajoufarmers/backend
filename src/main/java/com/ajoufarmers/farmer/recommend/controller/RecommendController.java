package com.ajoufarmers.farmer.recommend.controller;

import com.ajoufarmers.farmer.recommend.dto.ConditionsDto;
import com.ajoufarmers.farmer.recommend.dto.RecommendPlantDto;
import com.ajoufarmers.farmer.recommend.service.RecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommend")
public class RecommendController {

    private final RecommendService recommendService;

    @GetMapping("list")
    public List<RecommendPlantDto> recommend(@RequestParam int category,
                                             @RequestParam int size,
                                             @RequestParam int difficulty,
                                             @RequestParam int brightness,
                                             @RequestParam int waterRate){
        return recommendService.findByConditions(new ConditionsDto(category, size, difficulty, brightness, waterRate));
    }

}
