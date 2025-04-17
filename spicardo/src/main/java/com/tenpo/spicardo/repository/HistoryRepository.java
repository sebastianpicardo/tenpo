package com.tenpo.spicardo.repository;

import com.tenpo.spicardo.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}