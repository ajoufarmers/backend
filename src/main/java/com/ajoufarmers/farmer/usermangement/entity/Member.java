package com.ajoufarmers.farmer.usermangement.entity;

import com.ajoufarmers.farmer.usermangement.dto.MemberDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    @Builder
    public Member(String email, String name){
        this.email = email;
        this.name = name;
    }

    public MemberDto toDto(){
        return MemberDto.builder()
                .id(this.id)
                .email(this.email)
                .name(this.name)
                .build();
    }
}
