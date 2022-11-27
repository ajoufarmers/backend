package com.ajoufarmers.farmer.recommend.controller;

import com.ajoufarmers.farmer.recommend.dto.ConditionsDto;
import com.ajoufarmers.farmer.recommend.dto.RecommendPlantDto;
import com.ajoufarmers.farmer.recommend.service.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommend")
public class RecommendController {

    private final RecommendService recommendService;

    @GetMapping("list")
    public List<RecommendPlantDto> recommend(ConditionsDto conditionsDto){
        return recommendService.findByConditions(conditionsDto);
    }

}
