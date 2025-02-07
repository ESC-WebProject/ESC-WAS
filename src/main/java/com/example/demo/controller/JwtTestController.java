package com.example.demo.controller;

import com.example.demo.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jwt-test")
public class JwtTestController {

    private final JwtUtil jwtUtil;

    public JwtTestController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // 토큰 검증 API, 스웨거에선 자물쇠 표시 눌러서 JWT값을 value에 넣어야 정상 작동
    @Operation(summary = "JWT 토큰 검증", description = "전달된 JWT 토큰이 유효한지 확인합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "JWT 유효"),
            @ApiResponse(responseCode = "401", description = "JWT가 유효하지 않음")
    })
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(HttpServletRequest request) {
        String token = jwtUtil.extractToken(request);

        if (token == null || !jwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("{\"error\": \"Invalid or missing JWT\"}");
        }

        return ResponseEntity.ok().body("{\"message\": \"JWT is valid\"}");
    }

    // 토큰에서 사용자 id 추출하는 API, 스웨거에선 자물쇠 표시 눌러서 JWT값을 value에 넣어야 정상 작동
    @Operation(summary = "JWT에서 사용자 정보 추출", description = "JWT 토큰에서 studentId를 추출합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "JWT에서 studentId 추출 성공"),
            @ApiResponse(responseCode = "401", description = "JWT가 유효하지 않음")
    })
    @GetMapping("/extract")
    public ResponseEntity<?> extractUserFromToken(HttpServletRequest request) {
        String token = jwtUtil.extractToken(request); // ✅ 공통 메서드 사용

        if (token == null || !jwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("{\"error\": \"Invalid or missing JWT\"}");
        }

        String studentId = jwtUtil.extractUsername(token);
        return ResponseEntity.ok().body("{\"studentId\": \"" + studentId + "\"}");
    }
}
