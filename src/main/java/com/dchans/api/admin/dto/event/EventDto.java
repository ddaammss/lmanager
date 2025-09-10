package com.dchans.api.admin.dto.event;

import lombok.Getter;
import lombok.Setter;

public record CommunicationDto(
) {
    @Getter
    @Setter
    public static class CommunicationRequestDto {
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
    public static class CommunicationResponseDto {
        private String seq;
        private String title;
        private String content;
        private String answer;
        private String categoryType;
        private Integer status;
        private String createdAt;
        private String createdBy;

        private String statusNm;
        private String categoryTypeNm;
    }

    @Getter
    @Setter
    public static class CommunicationUpdateDto {
        private String seq;
        private String answer;
        private String status;
    }
}