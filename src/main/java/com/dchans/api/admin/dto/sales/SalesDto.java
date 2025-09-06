package com.dchans.api.admin.dto.sales;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public record SalesDto(
) {
    @Getter
    @Setter
    public static class SalesRequestDto {
        private String startDate;
        private String endDate;
        private String name;
        private List<String> payType;
        private int page = 1;        // 요청 페이지 (1부터 시작)
        private int pageSize = 10;   // 페이지당 개수
        private int offset;

        public int getOffset() {
            return (page - 1) * pageSize;
        }

        private String seq;
    }

    @Getter
    @Setter
    public static class SalesResponseDto {
        private String seq;
        private String salesCode;
        private String salesDate;
        private String salesPrice;
        private String storeCode;
        private String payType;
        private String createdAt;

        private String storeName;
        private String payName;  // 변환된 카테고리명
    }

    @Getter
    @Setter
    public static class SalesCreateDto {
        private String seq;
        private String salesCode;
        private String salesDate;
        private String salesPrice;
        private String storeCode;
        private String payType;
    }
}