package com.ajoufarmers.farmer.diary.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class WriteDiaryDto {

    private Long memberId;

    private LocalDate date;

    private Integer state;

    private String content;
}
