package com.ajoufarmers.farmer.diary.dto;


import com.ajoufarmers.farmer.diary.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class WriteDiaryDto {

    private Long memberId;

    private String date;

    private Integer state;

    private String content;

    public Diary toDiary(){
        return Diary.builder()
                .memberId(memberId)
                .date(date)
                .state(state)
                .content(content)
                .build();
    }
}
