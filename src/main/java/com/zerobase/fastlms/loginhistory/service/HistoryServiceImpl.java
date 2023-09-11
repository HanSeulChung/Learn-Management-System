package com.zerobase.fastlms.loginhistory.service;

import com.zerobase.fastlms.loginhistory.dto.HistoryDto;
import com.zerobase.fastlms.loginhistory.entity.History;
import com.zerobase.fastlms.loginhistory.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService{

    private final HistoryRepository historyRepository;

    @Override
    public void saveLogOnLogin(History history) {

        historyRepository.save(history);
    }


    @Override
    public List<HistoryDto> getUserLoginHistoryDtos(String userId) {

        List<History> historyList= historyRepository.findLoginHistoriesByUserIdOrderByLoginDtDesc(userId);

        return HistoryDto.of(historyList);

    }

}
