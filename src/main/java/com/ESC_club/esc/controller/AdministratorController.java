package com.ESC_club.esc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class AdministratorController {

    @GetMapping("/administrator/Student_ID")
    public String administrator_Student_ID() {

        return "아직 덜 만듦";
    }
}

