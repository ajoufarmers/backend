package com.ajoufarmers.farmer.mypage.controller;

import com.ajoufarmers.farmer.mypage.dto.MyPageEntryDto;
import com.ajoufarmers.farmer.mypage.entity.MyPageEntry;
import com.ajoufarmers.farmer.mypage.service.MyPageEntryService;
import com.ajoufarmers.farmer.plantdictionary.entity.Plant;
import com.ajoufarmers.farmer.plantdictionary.service.PlantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class MyPageControllerTest {
    @Autowired private MyPageController myPageController;
    @Autowired private MyPageEntryService myPageEntryService;
    @Autowired private PlantService plantService;

    @Test
    void createMyPlant() {
    }

    @Test
    void getMyPlantList() throws ParseException {
        myPageController.createMyPlant(1L, 1L, "/1/mypage/1", "2022-11-20", "모다피");
        myPageController.createMyPlant(2L, 2L, "/1/mypage/2", "2022-11-19", "우츠통");
        myPageController.createMyPlant(1L, 3L, "/1/mypage/3", "2022-11-15", "우츠보트");

        System.out.println(myPageController.getMyPlantList(1L).toString());
    }

    @Test
    void modifyMyPlantNickname() throws ParseException {
        MyPageEntryDto newEntry = myPageEntryService.saveMyPlant(
                MyPageEntry.builder()
                        .memberId(1L)
                        .plantId(1L)
                        .imgUri("/1/mypage/1")
                        .waterDate("2022-11-20")
                        .nickname("모다피").build().toDto()
        );
        myPageController.modifyMyPlantNickname(newEntry.getId(), "에어팟");

        System.out.println(myPageController.getMyPlantList(1L).toString());
    }

    @Test
    void modifyMyPlantImage() throws ParseException {
        MyPageEntryDto newEntry = myPageEntryService.saveMyPlant(
                MyPageEntry.builder()
                        .memberId(1L)
                        .plantId(1L)
                        .imgUri("/1/mypage/1")
                        .waterDate("2022-11-20")
                        .nickname("모다피").build().toDto()
        );
        myPageController.modifyMyPlantImage(newEntry.getId(), "/1/mypage/11");

        System.out.println(myPageController.getMyPlantList(1L).toString());
    }

    @Test
    void modifyMyPlantWaterDate() throws ParseException {
        MyPageEntryDto newEntry = myPageEntryService.saveMyPlant(
                MyPageEntry.builder()
                        .memberId(1L)
                        .plantId(1L)
                        .imgUri("/1/mypage/1")
                        .waterDate("2022-11-20")
                        .nickname("모다피").build().toDto()
        );
        myPageController.modifyMyPlantWaterDate(newEntry.getId(), "2022-12-01");

        System.out.println(myPageController.getMyPlantList(1L).toString());
    }

    @Test
    void getWaterTimingCheckList() throws ParseException {
        addPlants();
        System.out.println("콩나물 id: " + plantService.findOne("콩나물").get().getId().toString());
        addMyPageEntries();

        //System.out.println(newEntryList.toString());
        System.out.println("식물 리스트: " + myPageController.getMyPlantList(1L).toString());
        //System.out.println("물 알림 리스트: " + myPageController.getWaterTimingCheckList(1L).toString());
    }

    private void addMyPageEntries(){
        myPageEntryService.saveMyPlant(
                MyPageEntry.builder()
                        .memberId(1L)
                        .plantId(plantService.findOne("콩나물").get().getId())
                        .imgUri("/1/mypage/1")
                        .waterDate("2022-11-22")
                        .nickname("모다피").build().toDto());
        myPageEntryService.saveMyPlant(
                MyPageEntry.builder()
                        .memberId(1L)
                        .plantId(plantService.findOne("배추").get().getId())
                        .imgUri("/1/mypage/2")
                        .waterDate("2022-11-19")
                        .nickname("우츠동").build().toDto());
        myPageEntryService.saveMyPlant(
                MyPageEntry.builder()
                        .memberId(1L)
                        .plantId(plantService.findOne("양배추").get().getId())
                        .imgUri("/1/mypage/3")
                        .waterDate("2022-11-15")
                        .nickname("우츠보트").build().toDto());
    }
    private void addPlants(){
        plantService.save(Plant.builder()
                .name("콩나물")
                .category(4)
                .brightness(0)
                .description("콩나물이요")
                .difficulty(0)
                .harvestTime("7일")
                .humidity("높아야 함")
                .imgUri("콩나물 사진")
                .mangeInfo("빛 최대한 안 받게")
                .nutrition("영양성분이요")
                .size(0)
                .temperature("20도")
                .waterDate(1)
                .waterInfo("자주줘")
                .waterRate(2)
                .build());
        plantService.save(Plant.builder()
                .name("배추")
                .category(0)
                .brightness(3)
                .description("배추요")
                .difficulty(0)
                .harvestTime("14일")
                .humidity("적당히")
                .imgUri("배추 사진")
                .mangeInfo("빛 잘 드는 곳")
                .nutrition("배추 영양성분이요")
                .size(1)
                .temperature("24도")
                .waterDate(5)
                .waterInfo("적당히")
                .waterRate(1)
                .build());
        plantService.save(Plant.builder()
                .name("양배추")
                .category(0)
                .brightness(3)
                .description("양배추요")
                .difficulty(0)
                .harvestTime("14일")
                .humidity("적당히")
                .imgUri("양배추 사진")
                .mangeInfo("빛 잘 드는 곳")
                .nutrition("양배추 영양성분이요")
                .size(1)
                .temperature("24도")
                .waterDate(5)
                .waterInfo("적당히")
                .waterRate(1)
                .build());
    }
}