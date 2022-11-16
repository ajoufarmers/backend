package com.ajoufarmers.farmer.usermangement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String name;
}
