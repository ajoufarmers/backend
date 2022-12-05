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

    public List<DiaryDto> getDiaryListByMemberId(Long memberId){
        return diaryRepository.findByMemberId(memberId).stream()
                .map(diary -> diary.toDto())
                .collect(Collectors.toList());
    }

    public void deleteDiary(Long id){
        diaryRepository.deleteById(id);
    }

    public void writeDiary(WriteDiaryDto writeDiaryDto){
        Long memberId = writeDiaryDto.getMemberId();
        String date = writeDiaryDto.getDate();
        Integer state = writeDiaryDto.getState();
        String content = writeDiaryDto.getContent();

        diaryRepository.save(new Diary(memberId, date, state, content));
    }

    public ResponseEntity<?> updateState(Long id, int state){
        Optional<Diary> diary = diaryRepository.findById(id);
        if (diary.isPresent()) {
            Diary newDiary = diary.get();
            newDiary.changeState(state);
            diaryRepository.save(newDiary);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        return new ResponseEntity<>("fail", HttpStatus.OK);
    }

    public ResponseEntity<?> updateContent(Long id, String content){
        Optional<Diary> diary = diaryRepository.findById(id);
        if (diary.isPresent()) {
            Diary newDiary = diary.get();
            newDiary.changeContent(content);
            diaryRepository.save(newDiary);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        return new ResponseEntity<>("fail", HttpStatus.OK);
    }

}
