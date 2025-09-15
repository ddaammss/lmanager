package com.dchans.api.admin.dto.event;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record BannerDto(
) {
    @Getter
    @Setter
    public static class BannerRequestDto {
        private String seq;
        private int page = 1;        // 요청 페이지 (1부터 시작)
        private int pageSize = 10;   // 페이지당 개수
        private int offset;

        public int getOffset() {
            return (page - 1) * pageSize;
        }
    }

    @Getter
    @Setter
    public static class BannerResponseDto {
        private String seq;
        private String subSeq;
        private String mainName;
        private String mainContent;
        private String subName;
        private String subContent;
        private String createdAt;
        private String createdBy;

        private List<String> mainImages;
        private List<String> subImages;
    }

    @Getter
    @Setter
    public static class BannerCreateDto {
        private String seq;
        private String mainName;
        private String mainContent;
        private String subName;
        private String subContent;
    }

    @Getter
    @Setter
    public static class BannerUpdateDto {
        private String seq;
        private String name;
        private String content;
        private String type;
    }
}