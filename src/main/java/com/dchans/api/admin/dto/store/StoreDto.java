package com.dchans.api.admin.dto.store;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public record StoreDto(
) {
    @Getter
    @Setter
    public static class StoreRequestDto {
        private String seq;
        private String storeCode;
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

        private String parentSeq;
    }

    @Getter
    @Setter
    public static class StoreResponseDto {
        private String seq;
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
        private List<String> images;

    }

    @Getter
    @Setter
    public static class StoreCreateDto {
        private String seq;
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
        private List<String> images;
    }

    @Getter
    @Setter
    public static class StoreDeleteDto {
        private List<String> storeCodeList;

    }

    @Getter
    @Setter
    public static class StoreProductDto {
        private String parentSeq;
        private String storeCode;
        private String name;
        private String price;
    }
}