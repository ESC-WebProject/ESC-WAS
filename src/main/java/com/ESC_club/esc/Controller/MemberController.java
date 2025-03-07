package com.ESC_club.esc.Controller;

import com.ESC_club.esc.Dto.MemberDto;
import com.ESC_club.esc.Service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/members")
public class MemberController {

    private final MemberService memberService;

    //회원 전체 조회
    @GetMapping("/all")
    public List<MemberDto> getAllMembers() {
        return memberService.getAllMembers();
    }

    //이름으로 회원 조회
    @GetMapping("/name/{name}")
    public MemberDto getMemberByName(@PathVariable String name) {
        return memberService.getMemberByStudentName(name);
    }

    //학번으로 회원 조회
    @GetMapping("/id/{id}")
    public MemberDto getMemberById(@PathVariable int id) {
        return memberService.getMemberById(id);
    }

    //학번으로 회원정보 수정
    @PutMapping("/update/{id}")
    public MemberDto updateMember(@PathVariable int id, @RequestBody MemberDto memberDto) {
        return memberService.updateMember(id, memberDto);
    }

    //회원등록
    @PostMapping("/creation")
    public MemberDto createMember(@Valid @RequestBody MemberDto memberDto) {
        return memberService.createMember(memberDto);
    }

    //회원 삭제
    @DeleteMapping("/delete/{id}")
    public void deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
    }


}
