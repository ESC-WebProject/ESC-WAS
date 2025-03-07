package com.ESC_club.esc.Repository;

import com.ESC_club.esc.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByStudentName(String studentName);
    Optional<Member> findByStudentId(int studentId);


}





