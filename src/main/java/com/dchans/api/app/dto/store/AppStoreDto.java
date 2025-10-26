package com.dchans.api.app.dto.store;

import com.dchans.api.app.dto.image.AppImageDto;
import com.dchans.api.app.dto.product.AppProductDto;
import com.dchans.api.app.dto.review.AppReviewDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private String operatingHours;
    private String imagePath;
    private String memo;
    private String createdAt;

    private List<AppProductDto> productDto;
    private List<AppReviewDto> reviewDto;
    private List<AppImageDto> imageDto;
}
