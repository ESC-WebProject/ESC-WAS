package com.ESC_club.esc.repository;

import com.ESC_club.esc.entity.MileageShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MileageShopRepository extends JpaRepository<MileageShop, Long> {
}
