package com.tenpo.spicardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenpo.spicardo.entity.CalculationHistory;

@Repository
public interface CalculationHistoryRepository extends JpaRepository<CalculationHistory, Long> {
}