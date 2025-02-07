package com.example.demo.controller;

import com.example.demo.util.JwtUtil;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder; // ✅ BCrypt 비밀번호 검증을 위해 추가

    @Operation(summary = "로그인 요청", description = "학생 ID와 비밀번호를 입력받아 JWT를 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공, JWT 반환"),
            @ApiResponse(responseCode = "401", description = "인증 실패: 학생 ID 없음 또는 비밀번호 오류")
    })
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        try {
            UserDetails userDetails;
            // 1. 존재하는 id 인지 먼저 체크
            try {
                userDetails = userDetailsService.loadUserByUsername(String.valueOf(authRequest.getStudentId()));
            } catch (UsernameNotFoundException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("{\"error\": \"학생 ID가 존재하지 않습니다.\"}");
            }

            boolean isPasswordMatch = passwordEncoder.matches(authRequest.getPwd(), userDetails.getPassword());

            if (!isPasswordMatch) {
                logger.error("❌ 비밀번호 불일치: {}", authRequest.getStudentId());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("{\"error\": \"비밀번호가 올바르지 않습니다.\"}");
            }

            final String jwt = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthResponse(jwt));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"error\": \"비밀번호가 올바르지 않습니다.\"}");
        } catch (Exception e) {
            logger.error("🚨 알 수 없는 오류 발생", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"서버 오류가 발생했습니다.\"}");
        }
    }
}
