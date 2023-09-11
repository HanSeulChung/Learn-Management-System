package com.zerobase.fastlms.loginhistory.service;

import com.zerobase.fastlms.loginhistory.dto.HistoryDto;
import com.zerobase.fastlms.loginhistory.entity.History;

import java.util.List;

public interface HistoryService {
    void saveLogOnLogin(History history);
    List<HistoryDto> getUserLoginHistoryDtos(String userId);
}
