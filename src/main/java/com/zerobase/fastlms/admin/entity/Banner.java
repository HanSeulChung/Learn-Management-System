package com.zerobase.fastlms.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int openWay;
    boolean usingYn;
    String bannerName;
    String linkUrl;
    int sortOrder;
    LocalDateTime regDt;
    LocalDateTime udtDt;

    String filename;
    String urlFilename;

    /**
     *
     * 배너명
     * 배너파일(파일선택)
     * 링크 주소(TXT)
     * 오픈 방법 선택
     * 정렬 순서
     * 공개 여부 (체크박스)
     */

}

