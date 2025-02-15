package com.ESC_club.esc;

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
    private int student_id;

    @Column(nullable = false)
    private String pwd;

    @Column(nullable = false)
    private String Student_Name;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false, length = 1)
    private int grade;

    @Column(nullable = false)
    private String image_path;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean enrollment_status;

    @Column(nullable = false)
    private boolean management_auth;

    @Column(nullable = false)
    private int accumulated_milleage;

    @Column(nullable = false)
    private int held_mileage;


}
