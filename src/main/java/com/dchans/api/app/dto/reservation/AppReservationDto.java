package com.dchans.api.app.dto.reservation;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppReservationDto {
    private String seq;
    private String storeCode;
    private String storeName;
    private String categoryType;
    private String categoryName;
    private String address;
    private String grade;
    private String reviewCount;
    private String imagePath;
    private String memo;
    private String createdAt;

    private String serviceSeq;

    private String productName;
    private String productPrice;

    private String startTime;
    private String endTime;
    private List<String> reservedTimes;

    private List<String> businessHours;

}
