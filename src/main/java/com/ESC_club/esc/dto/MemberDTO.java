package com.ESC_club.esc.dto;

import com.ESC_club.esc.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private int id;
    private String name;
    private String department;
    private String major;
    private String phoneNum;
    private int grade;
    private String email;
    private int accumulateMileage;
    private int heldMileage;


    public MemberDTO(Member member) {
        this.id = member.getStudentId();
        this.name= member.getStudentName();
        this.department= member.getDepartment();
        this.major= member.getMajor();
        this.phoneNum= member.getPhoneNumber();
        this.grade= member.getGrade();
        this.email= member.getEmail();
        this.accumulateMileage=member.getAccumulatedMileage();
        this.heldMileage= member.getHeldMileage();
    }
}
