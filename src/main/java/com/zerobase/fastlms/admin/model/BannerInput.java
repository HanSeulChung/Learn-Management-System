package com.zerobase.fastlms.admin.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BannerInput {
    
    long id;
    int openWay;
    boolean usingYn;

    String BannerName;
    String imagePath;
    String linkUrl;
    int sortOrder;

    String filename;
    String urlFilename;

    //삭제를 위한
    String idList;
}
