package com.ajoufarmers.farmer.usermangement.login.entity;

import com.ajoufarmers.farmer.usermangement.login.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;

    @Builder
    public User(String email){
        this.email = email;
    }

    public UserDto toDto(){
        return UserDto.builder()
                .id(this.id)
                .email(this.email)
                .build();
    }
}
