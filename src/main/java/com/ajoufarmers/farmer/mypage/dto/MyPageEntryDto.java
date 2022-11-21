package com.ajoufarmers.farmer.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MyPageEntryDto {
    private Long id;
    private Long memberId;
    private Long plantId;
    private String imgUri;
    private String waterDate;
    private String nickname;
}
