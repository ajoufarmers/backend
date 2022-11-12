package com.ajoufarmers.farmer.usermangement.login.entity;

import com.ajoufarmers.farmer.usermangement.login.dto.MemberDto;
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

    @Builder
    public Member(String email){
        this.email = email;
    }

    public MemberDto toDto(){
        return MemberDto.builder()
                .id(this.id)
                .email(this.email)
                .build();
    }
}
