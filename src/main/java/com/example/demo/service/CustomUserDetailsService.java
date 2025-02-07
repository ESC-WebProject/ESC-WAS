package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // ✅ `studentId`로 사용자 정보 조회 (필수)
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String studentId) throws UsernameNotFoundException {
        Member member = memberRepository.findByStudentId(Integer.parseInt(studentId))
                .orElseThrow(() -> new UsernameNotFoundException("해당 학생 ID가 존재하지 않습니다: " + studentId));

        // ✅ Spring Security에서 사용할 `UserDetails` 객체 생성
        return User.builder()
                .username(String.valueOf(member.getStudentId()))
                .password(member.getPassword()) // 실제 암호화된 비밀번호
                .roles("USER") // 기본 역할 설정
                .build();
    }
}
