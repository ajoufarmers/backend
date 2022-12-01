package com.ajoufarmers.farmer.mypage.dto;

import com.ajoufarmers.farmer.mypage.entity.MyPageEntry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.swing.text.html.parser.Entity;

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
    private Boolean isWater;

    public MyPageEntry toEntity(){
        MyPageEntry myPageEntry = MyPageEntry.builder()
                .memberId(this.memberId)
                .plantId(this.plantId)
                .imgUri(this.imgUri)
                .waterDate(this.waterDate)
                .nickname(this.nickname).build();
        myPageEntry.setId(this.id);
        return myPageEntry;
    }
}
