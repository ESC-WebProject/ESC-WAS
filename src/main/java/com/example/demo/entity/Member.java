package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_ID") // 테이블의 컬럼명과 매핑
    private int studentId;

    @Column(name = "pwd")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "major")
    private String major;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "grade")
    private int grade;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "enrollment_status")
    private boolean enrollmentStatus;

    @Column(name = "management_auth")
    private boolean managementAuth;

    @Column(name = "accumulated_mileage")
    private int accumulatedMileage;

    @Column(name = "held_mileage")
    private int heldMileage;

    @OneToMany(mappedBy = "member")
    private List<Board> boards;

    @OneToMany(mappedBy = "member")
    private List<Comment> comments;

    @OneToMany(mappedBy = "member")
    private List<ExchangeRecord> exchangeRecords;
}
