package com.ajoufarmers.farmer.mypage.entity;

import com.ajoufarmers.farmer.mypage.dto.MyPageEntryDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class MyPageEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long memberId;
    @Column(nullable = false)
    private Long plantId;
    @Column(nullable = false)
    private String imgUri;
    @Column(nullable = false, length = 10)
    private String waterDate;
    @Column(nullable = false, length = 20)
    private String nickname;

    @Builder
    public MyPageEntry(Long memberId, Long plantId, String imgUri, String waterDate, String nickname) {
        this.memberId = memberId;
        this.plantId = memberId;
        this.imgUri = imgUri;
        this.waterDate = waterDate;
        this.nickname = nickname;
    }

    public MyPageEntryDto toDto() {
        return MyPageEntryDto.builder()
                .id(this.id)
                .memberId(this.memberId)
                .plantId(this.plantId)
                .imgUri(this.imgUri)
                .waterDate(this.waterDate)
                .nickname(this.nickname)
                .build();
    }
}
