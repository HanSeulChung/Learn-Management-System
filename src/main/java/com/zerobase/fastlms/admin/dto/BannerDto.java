package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BannerDto {

    Long id;
    int openWay;
    boolean usingYn;
    String bannerName;
    String linkUrl;
    int sortOrder;
    String imagePath;
    LocalDateTime regDt;
    LocalDateTime udtDt;

    String filename;
    String urlFilename;


    long totalCount;
    long seq;
    public static List<BannerDto> of(List<Banner> banner) {

        if (banner != null) {
            List<BannerDto> bannerList = new ArrayList<>();
            for(Banner x : banner) {
                bannerList.add(of(x));
            }
            return bannerList;
        }

        return null;
    }

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .openWay(banner.getOpenWay())
                .usingYn(banner.isUsingYn())
                .linkUrl(banner.getLinkUrl())
                .sortOrder(banner.getSortOrder())
                .regDt(banner.getRegDt())
                .udtDt(LocalDateTime.now())
                .urlFilename(banner.getUrlFilename())
                .filename(banner.getFilename())
                .build();
    }

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return regDt != null ? regDt.format(formatter) : "";
    }
}
