package com.ESC_club.esc;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

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
    @Column(name = "student_id", nullable = false, length = 8, unique = true)
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

    @Builder.Default
    @Column(nullable = false)
    private int accumulated_mileage = 0;

    @Builder.Default
    @Column(nullable = false)
    private int held_mileage = 0;

}
