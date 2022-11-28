package com.ajoufarmers.farmer.diary.service;

import com.ajoufarmers.farmer.diary.dto.DiaryDto;
import com.ajoufarmers.farmer.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public List<DiaryDto> getDiaryListByMemberId(Long memberId){
        return diaryRepository.findByMemberId(memberId).stream()
                .map(diary -> diary.toDto())
                .collect(Collectors.toList());
    }

    public void deleteDiary(Long id){
        diaryRepository.deleteById(id);
    }

}
