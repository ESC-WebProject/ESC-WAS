package com.ESC_club.esc.repository;

import com.ESC_club.esc.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByStudentName(String studentName);
    Optional<Member> findByStudentId(int studentId);


}





