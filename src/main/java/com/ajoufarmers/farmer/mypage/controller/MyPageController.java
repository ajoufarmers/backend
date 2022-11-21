package com.ajoufarmers.farmer.mypage.controller;

import com.ajoufarmers.farmer.mypage.entity.MyPageEntry;
import com.ajoufarmers.farmer.mypage.service.MyPageEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MyPageController {
    private final MyPageEntryService myPageEntryService;

    @Autowired
    public MyPageController(MyPageEntryService myPageEntryService){
        this.myPageEntryService = myPageEntryService;
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
    public ResponseEntity<?> getMyPlantList(){
        return new ResponseEntity<>(myPageEntryService.findMyPlants(), HttpStatus.OK);
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
}
