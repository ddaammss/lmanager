package com.dchans.api.admin.dto.shop;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record ShopDto(
) {
    @Getter
    @Setter
    public static class ShopRequestDto {
        private String seq;
        private String name;
        private String price;
        private int page = 1;        // 요청 페이지 (1부터 시작)
        private int pageSize = 10;   // 페이지당 개수
        private int offset;

        public int getOffset() {
            return (page - 1) * pageSize;
        }
    }

    @Getter
    @Setter
    public static class ShopResponseDto {
        private String seq;
        private String name;
        private String price;
        private String createdAt;
        private String createdBy;

        private List<String> images;
    }

    @Getter
    @Setter
    public static class ShopCreateDto {
        private String seq;
        private String name;
        private String price;
    }

    @Getter
    @Setter
    public static class ShopUpdateDto {
        private String seq;
        private String name;
        private String price;
    }

    @Getter
    @Setter
    public static class ShopDeleteDto {
        private List<String> seqList;

    }

}