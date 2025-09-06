package com.dchans.api.admin.dto.ad;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record AdDto(
) {
    @Getter
    @Setter
    public static class AdRequestDto {
        private String startDate;
        private String endDate;
        private String name;
        private List<String> categoryType;
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
    public static class AdResponseDto {
        private String seq;
        private String storeCode;
        private String startDate;
        private String endDate;
        private Integer status;
        private String categoryType;
        private String ranking;
        private String createdAt;

        private String storeName;
        private String categoryName;
        private String period;
    }

    @Getter
    @Setter
    public static class AdCreateDto {
        private String seq;
        private String storeCode;
        private String categoryType;
    }

    @Getter
    @Setter
    public static class AdUpdateDto {
        private String seq;
        private String startDate;
        private String endDate;
        private String categoryType;
        private String ranking;
        private String status;
    }

    @Getter
    @Setter
    public static class AdDeleteDto {
        private List<String> seqList;
    }

}