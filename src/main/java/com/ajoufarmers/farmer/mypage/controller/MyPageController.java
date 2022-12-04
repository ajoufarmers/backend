package com.ajoufarmers.farmer.mypage.controller;

import com.ajoufarmers.farmer.mypage.dto.MyPageEntryDto;
import com.ajoufarmers.farmer.mypage.entity.MyPageEntry;
import com.ajoufarmers.farmer.mypage.service.MyPageEntryService;
import com.ajoufarmers.farmer.plantdictionary.dto.PlantDto;
import com.ajoufarmers.farmer.plantdictionary.entity.Plant;
import com.ajoufarmers.farmer.plantdictionary.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class MyPageController {
    private final MyPageEntryService myPageEntryService;
    private final PlantService plantService;

    @Autowired
    public MyPageController(MyPageEntryService myPageEntryService, PlantService plantService){
        this.myPageEntryService = myPageEntryService;
        this.plantService = plantService;
    }

    @PostMapping("/mypage/new")
    public ResponseEntity<?> createMyPlant(
            @RequestParam Long memberId,
            @RequestParam Long plantId,
            @RequestParam String imgUri,
            @RequestParam String waterDate,
            @RequestParam String nickname){
        myPageEntryService.saveMyPlant(new MyPageEntry(memberId, plantId, imgUri, waterDate, nickname).toDto());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/mypage/list")
    public ResponseEntity<?> getMyPlantList(@RequestParam Long memberId) throws ParseException {
        List<MyPageEntryDto> myPageEntryDtoList = myPageEntryService.findMyPlants(memberId);
        for (MyPageEntryDto myPageEntryDto : myPageEntryDtoList) {
            myPageEntryDto.setIsWater(getWaterTimingCheck(myPageEntryDto));
        }
        return new ResponseEntity<>(myPageEntryDtoList, HttpStatus.OK);
    }

    @PutMapping("/mypage/modify/nickname")
    public ResponseEntity<?> modifyMyPlantNickname(@RequestParam Long id, @RequestParam String nickname){
        Optional<MyPageEntryDto> myPageEntryDto = myPageEntryService.findOne(id);
        if(myPageEntryDto.isPresent()) {
            MyPageEntryDto newEntry = myPageEntryDto.get();
            newEntry.setNickname(nickname);
            myPageEntryService.updateMyPlant(newEntry);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        return new ResponseEntity<>("fail", HttpStatus.OK);
    }
    @PutMapping("/mypage/modify/image")
    public ResponseEntity<?> modifyMyPlantImage(@RequestParam Long id, @RequestParam String imgUri){
        Optional<MyPageEntryDto> myPageEntryDto = myPageEntryService.findOne(id);
        if(myPageEntryDto.isPresent()) {
            MyPageEntryDto newEntry = myPageEntryDto.get();
            newEntry.setImgUri(imgUri);
            myPageEntryService.updateMyPlant(newEntry);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        return new ResponseEntity<>("fail", HttpStatus.OK);
    }
    @PutMapping("/mypage/modify/waterdate")
    public ResponseEntity<?> modifyMyPlantWaterDate(@RequestParam Long id, @RequestParam String waterDate){
        Optional<MyPageEntryDto> myPageEntryDto = myPageEntryService.findOne(id);
        if(myPageEntryDto.isPresent()) {
            MyPageEntryDto newEntry = myPageEntryDto.get();
            newEntry.setWaterDate(waterDate);
            myPageEntryService.updateMyPlant(newEntry);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        return new ResponseEntity<>("fail", HttpStatus.OK);
    }

    @PostMapping("/mypage/delete")
    public ResponseEntity<?> deleteMyPlant(@RequestParam Long id){
        Optional<MyPageEntryDto> myPageEntryDto = myPageEntryService.findOne(id);
        if(myPageEntryDto.isPresent()){
            myPageEntryService.deleteMyPlant(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("fail", HttpStatus.OK);
    }

    private Boolean getWaterTimingCheck(MyPageEntryDto myPageEntryDto) throws ParseException {
        boolean isWater = false;

        Date lateDate = new SimpleDateFormat("yyyy-MM-dd").parse(myPageEntryDto.getWaterDate());
        Date curDate = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
        long diffSec = (curDate.getTime() - lateDate.getTime()) / 1000;

        PlantDto plantInfo = plantService.findOne(myPageEntryDto.getPlantId()).get();

        isWater = diffSec / (24 * 60 * 60) >= plantInfo.getWaterDate();
        return isWater;
    }
}
