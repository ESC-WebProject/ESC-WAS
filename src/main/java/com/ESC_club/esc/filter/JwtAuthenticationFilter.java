package com.ESC_club.esc.filter;

import com.ESC_club.esc.service.CustomUserDetailsService;
import com.ESC_club.esc.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(CustomUserDetailsService customUserDetailsService, JwtUtil jwtUtil) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // ✅ 요청에서 JWT 추출
        String token = jwtUtil.extractToken(request);

        if (token != null) {
            try {
                // ✅ 토큰 유효성 검사
                if (jwtUtil.validateToken(token)) {
                    // ✅ 토큰에서 studentId 추출
                    String studentId = jwtUtil.extractUsername(token);

                    // ✅ SecurityContext에 인증 정보가 없는 경우 처리
                    if (studentId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                        // ✅ 데이터베이스에서 사용자 정보 조회
                        UserDetails userDetails = customUserDetailsService.loadUserByUsername(studentId);

                        // ✅ 인증 객체 생성 및 SecurityContext 설정
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } catch (Exception e) {
                logger.error("JWT 검증 실패: {}", e.getMessage());
            }
        }

        // ✅ 다음 필터로 요청 전달
        chain.doFilter(request, response);
    }
}