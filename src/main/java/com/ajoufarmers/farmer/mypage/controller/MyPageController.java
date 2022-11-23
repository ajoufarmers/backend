package com.ajoufarmers.farmer.mypage.controller;

import com.ajoufarmers.farmer.mypage.entity.MyPageEntry;
import com.ajoufarmers.farmer.mypage.service.MyPageEntryService;
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
    public void createMyPlant(
            @RequestParam Long memberId,
            @RequestParam Long plantId,
            @RequestParam String imgUri,
            @RequestParam String waterDate,
            @RequestParam String nickname){
        myPageEntryService.saveMyPlant(new MyPageEntry(memberId, plantId, imgUri, waterDate, nickname));
    }

    @GetMapping("/mypage/list")
    public ResponseEntity<?> getMyPlantList(@RequestParam Long memberId){
        return new ResponseEntity<>(myPageEntryService.findMyPlants(memberId), HttpStatus.OK);
    }

    @PutMapping("/mypage/modify/nickname")
    public void modifyMyPlantNickname(@RequestParam Long id, @RequestParam String nickname){
        Optional<MyPageEntry> myPageEntry = myPageEntryService.findOne(id);
        if(myPageEntry.isPresent()) {
            MyPageEntry newEntry = myPageEntry.get();
            newEntry.setNickname(nickname);
            myPageEntryService.updateMyPlant(newEntry);
        }
    }
    @PutMapping("/mypage/modify/image")
    public void modifyMyPlantImage(@RequestParam Long id, @RequestParam String imgUri){
        Optional<MyPageEntry> myPageEntry = myPageEntryService.findOne(id);
        if(myPageEntry.isPresent()) {
            MyPageEntry newEntry = myPageEntry.get();
            newEntry.setImgUri(imgUri);
            myPageEntryService.updateMyPlant(newEntry);
        }
    }
    @PutMapping("/mypage/modify/waterdate")
    public void modifyMyPlantWaterDate(@RequestParam Long id, @RequestParam String waterDate){
        Optional<MyPageEntry> myPageEntry = myPageEntryService.findOne(id);
        if(myPageEntry.isPresent()) {
            MyPageEntry newEntry = myPageEntry.get();
            newEntry.setWaterDate(waterDate);
            myPageEntryService.updateMyPlant(newEntry);
        }
    }
    @GetMapping("/mypage/watertiming")
    public ResponseEntity<?> getWaterTimingCheckList(@RequestParam Long memberId) throws ParseException {
        List<MyPageEntry> myPageEntryList = myPageEntryService.findMyPlants(memberId);
        List<Boolean> checkList = new ArrayList<>(myPageEntryList.size());

        for (MyPageEntry myPageEntry : myPageEntryList) {
            Date lateDate = new SimpleDateFormat("yyyy-MM-dd").parse(myPageEntry.getWaterDate());
            Date curDate = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
            long diffSec = (curDate.getTime() - lateDate.getTime()) / 1000;

            Plant plantInfo = plantService.findOne(myPageEntry.getPlantId()).get();
            if (diffSec / (24 * 60 * 60) >= plantInfo.getWaterDate())
                checkList.add(true);
            else
                checkList.add(false);
        }
        return new ResponseEntity<>(checkList, HttpStatus.OK);
    }
}
