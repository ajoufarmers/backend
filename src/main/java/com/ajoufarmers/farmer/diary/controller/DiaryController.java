package com.ajoufarmers.farmer.diary.controller;

import com.ajoufarmers.farmer.diary.dto.DiaryDto;
import com.ajoufarmers.farmer.diary.dto.WriteDiaryDto;
import com.ajoufarmers.farmer.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    public void writeDiary(@RequestBody WriteDiaryDto writeDiaryDto){
        diaryService.writeDiary(writeDiaryDto);
    }
    @GetMapping("/list/{memberId}")
    public List<DiaryDto> getDiaryList(@PathVariable Long memberId){
        return diaryService.getDiaryListByMemberId(memberId);
    }

    @DeleteMapping("/{id}")
    public void deleteDiary(@PathVariable Long id){
        diaryService.deleteDiary(id);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> updateDiary(@PathVariable Long id, @RequestBody WriteDiaryDto writeDiaryDto){
        return diaryService.updateDiary(id, writeDiaryDto);
    }


}
