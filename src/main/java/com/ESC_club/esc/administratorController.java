package com.ESC_club.esc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class administratorController {

    @GetMapping("/administrator/Student_ID")
    public String administrator_Student_ID() {

        return "아직 덜 만듦";
    }
}

