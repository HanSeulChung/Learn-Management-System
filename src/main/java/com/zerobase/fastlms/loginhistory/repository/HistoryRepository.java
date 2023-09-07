package com.zerobase.fastlms.loginhistory.repository;

import com.zerobase.fastlms.loginhistory.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
