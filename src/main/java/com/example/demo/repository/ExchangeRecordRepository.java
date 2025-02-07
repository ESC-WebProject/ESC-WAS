package com.example.demo.repository;

import com.example.demo.entity.ExchangeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRecordRepository extends JpaRepository<ExchangeRecord, Integer> {
}