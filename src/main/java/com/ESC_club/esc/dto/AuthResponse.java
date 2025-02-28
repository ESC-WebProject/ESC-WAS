package com.ESC_club.esc.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthResponse { //리턴해 줄 jwt를 전달하는 dto
    private String jwt;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

}
