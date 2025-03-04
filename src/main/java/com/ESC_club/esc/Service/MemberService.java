package com.ESC_club.esc.Service;

import com.ESC_club.esc.Entity.Member;
import com.ESC_club.esc.Dto.MemberDto;
import com.ESC_club.esc.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    //모든 회원 조회 메서드
    public List<MemberDto> getAllMembers()
    {
        return memberRepository.findAll().stream()
                .map(MemberDto::new)
                .collect(Collectors.toList());
    }

    //이름으로 특정 회원 조회 메서드
    public MemberDto getMemberByStudentName(String studentName)
    {
        return memberRepository.findByStudentName(studentName)
                .map(MemberDto::new)
                .orElseThrow(()->new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
    }

    //학번으로 특정 회원 조회 메서드
    public MemberDto getMemberById(int id)
    {
        return memberRepository.findByStudentId(id)  // 주어진 ID로 회원을 찾음
                .map(MemberDto::new)  // Member 엔티티를 MemberDto로 변환
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        // 회원이 없을 경우 예외 발생
    }

    //새로운 회원 등록 메서드
    public MemberDto createMember(MemberDto memberDto)
    {
        Member member = Member.builder()
                .studentId(memberDto.getId())
                .pwd(passwordEncoder.encode("defaultPassword")) // 기본 비밀번호 설정 (이후 변경 가능)
                .studentName(memberDto.getName())
                .department(memberDto.getDepartment())
                .major(memberDto.getMajor())
                .grade(memberDto.getGrade())
                .email(memberDto.getEmail())
                .enrollmentStatus(false)
                .managementAuth(false) // 기본적으로 USER 권한 부여
                .accumulatedMileage(memberDto.getAccumulateMileage())
                .heldMileage(memberDto.getHeldMileage())
                .build();

        memberRepository.save(member);
        return new MemberDto(member);
    }

    //회원정보 업데이트 매세드
    public MemberDto updateMember(int id, MemberDto memberDto)
    {
        // id로 회원을 찾음 (없으면 예외 발생)
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
        member.setStudentName(memberDto.getName());
        member.setDepartment(memberDto.getDepartment());
        member.setMajor(memberDto.getMajor());
        member.setGrade(memberDto.getGrade());
        member.setEmail(memberDto.getEmail());
        member.setAccumulatedMileage(memberDto.getAccumulateMileage());
        member.setHeldMileage(memberDto.getHeldMileage());

        memberRepository.save(member);

        return new MemberDto(member);
    }

    //회원삭제 매세드
    public void deleteMember(int id)
    {
        if(!memberRepository.existsById(id))
        {
            throw new IllegalArgumentException("해당 회원이 존재하지 않습니다.");
        }
        memberRepository.deleteById(id);



    }



}
