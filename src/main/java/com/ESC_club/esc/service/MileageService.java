package com.ESC_club.esc.service;

import com.ESC_club.esc.entity.Member;
import com.ESC_club.esc.repository.MileageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MileageService {

    private final MileageRepository mileageRepository;

    public MileageService(MileageRepository mileageRepository) {
        this.mileageRepository = mileageRepository;
    }

    @Transactional
    public void increaseMileage(int studentId, int amount) {
        Member member = mileageRepository.findByStudentId(studentId);
        if (member != null) {
            member.setHeldMileage(member.getHeldMileage() + amount);
            member.setAccumulatedMileage(member.getAccumulatedMileage() + amount);
            mileageRepository.save(member);
        }
    }

    @Transactional
    public void decreaseMileage(int studentId, int amount) {
        Member member = mileageRepository.findByStudentId(studentId);
        if (member != null && member.getHeldMileage() >= amount) {
            member.setHeldMileage(member.getHeldMileage() - amount);
            mileageRepository.save(member);
        }
    }

    public int getMileage(int studentId) {
        Member member = mileageRepository.findByStudentId(studentId);
        return (member != null) ? member.getHeldMileage() : 0;
    }
}
