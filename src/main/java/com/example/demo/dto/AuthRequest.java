package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest { // 로그인 정보를 받는 dto
    private int studentId;
    private String pwd;

    public AuthRequest() { }

}