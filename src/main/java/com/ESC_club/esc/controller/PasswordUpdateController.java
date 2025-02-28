package com.ESC_club.esc.controller;

import com.ESC_club.esc.entity.Member;
import com.ESC_club.esc.repository.MemberRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PasswordUpdateController {
    //테스트 용 컨트롤러 (추후 마이페이지로 이동 될듯?)
    private static final Logger logger = LoggerFactory.getLogger(PasswordUpdateController.class);

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public PasswordUpdateController(PasswordEncoder passwordEncoder, MemberRepository memberRepository) {
        this.passwordEncoder = passwordEncoder;
        this.memberRepository = memberRepository;
    }

    @Operation(summary = "사용자 비밀번호 변경", description = "기존 비밀번호 없이 새 비밀번호를 설정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "비밀번호 변경 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @ApiResponse(responseCode = "404", description = "사용자 없음")
    })
    @PutMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
            @RequestParam int studentId,
            @RequestParam String newPassword) {

        // 사용자 찾기
        Optional<Member> optionalMember = memberRepository.findById(studentId);
        if (optionalMember.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다.");
        }

        Member member = optionalMember.get();

        // 새 비밀번호 암호화 후 저장
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        member.setPwd(encodedNewPassword);
        memberRepository.save(member);

        logger.info("사용자 ID {}의 비밀번호가 변경되었습니다.", studentId);
        return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다.");
    }
}
