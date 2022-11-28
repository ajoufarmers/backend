package com.ajoufarmers.farmer.diary.entity;

import com.ajoufarmers.farmer.diary.dto.DiaryDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@Getter
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id" ,nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Integer state;

    private String content;

    @Builder
    public Diary(Long memberId, LocalDate date, Integer state, String content) {
        this.memberId = memberId;
        this.date = date;
        this.state = state;
        this.content = content;
    }

    public DiaryDto toDto(){
        return DiaryDto.builder()
                .id(this.id)
                .date(this.date)
                .state(this.state)
                .content(this.content)
                .build();
    }
}
