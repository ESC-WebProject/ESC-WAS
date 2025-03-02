package com.ESC_club.esc.repository;

import com.ESC_club.esc.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MileageRepository extends JpaRepository<Member, Integer> {
    Member findByStudentId(int studentId);
}



