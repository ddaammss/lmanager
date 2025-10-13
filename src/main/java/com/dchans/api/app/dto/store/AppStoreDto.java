package com.dchans.api.app.dto.store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppStoreDto {
    private String seq;
    private String storeCode;
    private String storeName;
    private String description;
    private String categoryName;
    private String address;
    private String grade;
    private String reviewCount;
    private double latitude;
    private double longitude;
    private double distance; // 계산된 거리
}
