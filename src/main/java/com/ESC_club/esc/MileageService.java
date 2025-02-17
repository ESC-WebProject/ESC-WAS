package com.ESC_club.esc;

import com.ESC_club.esc.Member;
import com.ESC_club.esc.MileageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MileageService {

    private final MileageRepository mileageRepository;

    public MileageService(MileageRepository mileageRepository) {
        this.mileageRepository = mileageRepository;
    }

    @Transactional
    public void increaseMileage(int student_Id, int amount) {
        Member member = mileageRepository.findByStudent_Id(student_Id);
        if (member != null) {
            member.setHeld_mileage(member.getHeld_mileage() + amount);
            member.setAccumulated_mileage(member.getAccumulated_mileage() + amount);
            mileageRepository.save(member);
        }
    }

    @Transactional
    public void decreaseMileage(int student_Id, int amount) {
        Member member = mileageRepository.findByStudent_Id(student_Id);
        if (member != null && member.getHeld_mileage() >= amount) {
            member.setHeld_mileage(member.getHeld_mileage() - amount);
            mileageRepository.save(member);
        }
    }

    public int getMileage(int student_Id) {
        Member member = mileageRepository.findByStudent_Id(student_Id);
        return (member != null) ? member.getHeld_mileage() : 0;
    }
}
