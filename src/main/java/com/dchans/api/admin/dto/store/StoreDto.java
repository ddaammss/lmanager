package com.dchans.api.admin.dto.store;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public record StoreDto(
        String storeCode,
        String storeName,
        Integer categoryType,
        String categoryName,  // 변환된 카테고리명
        Integer status,
        String statusName,    // 변환된 상태명
        String businessNumber,
        String ceoName,
        String phone,
        String email,
        String zipCode,
        String address,
        String addressDetail,
        String memo,
        Long createdBy,
        Long updatedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    @Getter
    @Setter
    public static class StoreRequestDto {
        private String startDate;
        private String endDate;
        private String name;
        private String address;
        private List<String> categoryType;
        private int page = 1;        // 요청 페이지 (1부터 시작)
        private int pageSize = 10;   // 페이지당 개수
        private int offset;

        public int getOffset() {
            return (page - 1) * pageSize;
        }

        private String storeCode;
    }

    @Getter
    @Setter
    public static class StoreResponseDto {
        private String storeCode;
        private String storeName;
        private String categoryType;
        private String categoryName;  // 변환된 카테고리명
        private Integer status;
        private String statusName;    // 변환된 상태명
        private String ceoName;
        private String phone;
        private String email;
        private String zipCode;
        private String address;
        private String addressDetail;
        private String description;
        private String memo;
        private String startTime;
        private String endTime;
        private Long createdBy;
        private Long updatedBy;
        private String createdAt;
        private String updatedAt;

        private List<StoreProductDto> products;

    }

    @Getter
    @Setter
    public static class StoreCreateDto {
        private String storeCode;
        private String storeName;
        private String categoryType;
        private String ceoName;
        private String phone;
        private String email;
        private String zipCode;
        private String address;
        private String addressDetail;
        private String description;
        private String memo;
        private String startTime;
        private String endTime;
        private String status;
        private List<StoreProductDto> products;
    }

    @Getter
    @Setter
    public static class StoreDeleteDto {
        private List<String> storeCodeList;

    }

    @Getter
    @Setter
    public static class StoreProductDto {
        private String storeCode;
        private String productCode;
        private String name;
        private String price;
    }
}