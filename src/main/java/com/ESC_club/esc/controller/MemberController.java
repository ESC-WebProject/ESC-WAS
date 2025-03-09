package com.ESC_club.esc.controller;

import com.ESC_club.esc.dto.MemberDTO;
import com.ESC_club.esc.service.MemberService;
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
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
    }

    //이름으로 회원 조회
    @GetMapping("/name/{name}")
    public MemberDTO getMemberByName(@PathVariable String name) {
        return memberService.getMemberByStudentName(name);
    }

    //학번으로 회원 조회
    @GetMapping("/id/{id}")
    public MemberDTO getMemberById(@PathVariable int id) {
        return memberService.getMemberById(id);
    }

    //학번으로 회원정보 수정
    @PutMapping("/update/{id}")
    public MemberDTO updateMember(@PathVariable int id, @RequestBody MemberDTO memberDto) {
        return memberService.updateMember(id, memberDto);
    }

    //회원등록
    @PostMapping("/creation")
    public MemberDTO createMember(@Valid @RequestBody MemberDTO memberDto) {
        return memberService.createMember(memberDto);
    }

    //회원 삭제
    @DeleteMapping("/delete/{id}")
    public void deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
    }


}
