package com.ESC_club.esc.controller;

import com.ESC_club.esc.dto.MileageDTO;
import com.ESC_club.esc.service.MileageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mileage")
public class MileageController {

    private final MileageService mileageService;

    public MileageController(MileageService mileageService) {
        this.mileageService = mileageService;
    }

    // 특정 유저의 마일리지 증가
    @PostMapping("/increase")
    public ResponseEntity<String> increaseMileage(@RequestBody MileageDTO mileageDTO) {
        mileageService.increaseMileage(mileageDTO.getStudentId(), mileageDTO.getAmount());
        return ResponseEntity.ok("Mileage increased successfully.");
    }

    // 특정 유저의 마일리지 감소
    @PostMapping("/decrease")
    public ResponseEntity<String> decreaseMileage(@RequestBody MileageDTO mileageDTO) {
        mileageService.decreaseMileage(mileageDTO.getStudentId(), mileageDTO.getAmount());
        return ResponseEntity.ok("Mileage decreased successfully.");
    }

    // 특정 유저의 현재 마일리지 조회
    @GetMapping("/{studentId}")
    public ResponseEntity<Integer> getMileage(@PathVariable int studentId) {
        int mileage = mileageService.getMileage(studentId);
        return ResponseEntity.ok(mileage);
    }
}

