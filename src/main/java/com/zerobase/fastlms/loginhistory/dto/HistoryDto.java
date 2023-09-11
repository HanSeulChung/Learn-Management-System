package com.zerobase.fastlms.loginhistory.dto;

import com.zerobase.fastlms.loginhistory.entity.History;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HistoryDto {

    Long id;
    String userId;
    LocalDateTime loginDt;
    String clientIp;
    String userAgent;

    public static List<HistoryDto> of(List<History> history) {

        if (history != null) {
            List<HistoryDto> historyList = new ArrayList<>();
            for(History x : history) {
                historyList.add(of(x));
            }
            return historyList;
        }

        return null;
    }

    public static HistoryDto of(History history) {
        return HistoryDto.builder()
                .id(history.getId())
                .userId(history.getUserId())
                .loginDt(history.getLoginDt())
                .clientIp(history.getClientIp())
                .userAgent(history.getUserAgent())
                .build();
    }
}
