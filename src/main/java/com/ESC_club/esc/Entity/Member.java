package com.ESC_club.esc.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @Column(nullable = false, length = 8, unique = true)
    private int studentId;

    @Column(nullable = false)
    private String pwd;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String major;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = false, length = 1)
    private int grade;

    @Column(nullable = true)
    private String imagePath;

    @Column(nullable = true)
    private String email;

    @Column(nullable = false)//재학 or 졸업여부, false면 재학 중 true면 졸업
    private boolean enrollmentStatus;

    @Column(nullable = false)//관리자 권한이면 true
    private boolean managementAuth;

    @Column(nullable = false)
    private int accumulatedMileage;

    @Column(nullable = false)
    private int heldMileage;


}
