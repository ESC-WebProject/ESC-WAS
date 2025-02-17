package com.ESC_club.esc;

import com.ESC_club.esc.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MileageRepository extends JpaRepository<Member, Integer> {
    @Query("SELECT m FROM Member m WHERE m.student_id = :student_id")
    Member findByStudent_Id(int student_id);
}



