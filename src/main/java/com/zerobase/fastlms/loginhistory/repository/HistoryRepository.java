package com.zerobase.fastlms.loginhistory.repository;

import com.zerobase.fastlms.loginhistory.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findLoginHistoriesByUserIdOrderByLoginDtDesc(String userId);
}
