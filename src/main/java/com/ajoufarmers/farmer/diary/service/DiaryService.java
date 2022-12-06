package com.ajoufarmers.farmer.diary.service;

import com.ajoufarmers.farmer.diary.dto.DiaryDto;
import com.ajoufarmers.farmer.diary.dto.WriteDiaryDto;
import com.ajoufarmers.farmer.diary.entity.Diary;
import com.ajoufarmers.farmer.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    // 일기 작성 기능
    public void writeDiary(WriteDiaryDto writeDiaryDto){
        diaryRepository.save(writeDiaryDto.toDiary());
    }

    // 사용자별 일기 찾기 기능
    public List<DiaryDto> getDiaryListByMemberId(Long memberId){

        return diaryRepository.findByMemberId(memberId).stream()
                .map(diary -> new DiaryDto(diary.getId(), diary.getMemberId(), diary.getDate(), diary.getState(), diary.getContent()))
                .collect(Collectors.toList());
    }

    // 일기 삭제 기능
    public void deleteDiary(Long id){
        diaryRepository.deleteById(id);
    }


    //  일기 수정 기능
    public ResponseEntity<?> updateDiary(Long id, WriteDiaryDto writeDiaryDto){
        Optional<Diary> diary = diaryRepository.findById(id);

        if (diary.isPresent()) {
            Diary findDiary = diary.get();

            findDiary.changeContent(writeDiaryDto.getContent());
            findDiary.changeState(writeDiaryDto.getState());

            diaryRepository.save(findDiary);

            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        return new ResponseEntity<>("fail", HttpStatus.OK);
    }

}
