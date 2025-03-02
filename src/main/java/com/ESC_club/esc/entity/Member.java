package com.ESC_club.esc.entity;

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
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, length = 1)
    private int grade;

    @Column(nullable = false)
    private String imagePath;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean enrollmentStatus;

    @Column(nullable = false)
    private boolean managementAuth;

    @Builder.Default
    @Column(nullable = false)
    private int accumulatedMileage = 0;

    @Builder.Default
    @Column(nullable = false)
    private int heldMileage = 0;

}
