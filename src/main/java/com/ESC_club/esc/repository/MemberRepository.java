package com.ESC_club.esc.repository;

import com.ESC_club.esc.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query("SELECT m FROM Member m WHERE m.student_id = :student_id")
    Optional<Member> findByStudent_id(int student_id);
}
