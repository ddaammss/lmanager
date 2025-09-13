package com.dchans.api.admin.dto.event;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record EventDto(
) {
    @Getter
    @Setter
    public static class EventRequestDto {
        private String seq;
        private String startDate;
        private String endDate;
        private String content;
        private int page = 1;        // 요청 페이지 (1부터 시작)
        private int pageSize = 10;   // 페이지당 개수
        private int offset;

        public int getOffset() {
            return (page - 1) * pageSize;
        }
    }

    @Getter
    @Setter
    public static class EventResponseDto {
        private String seq;
        private String eventName;
        private String startDate;
        private String endDate;
        private String content;
        private String createdAt;
        private String createdBy;

        private String eventDate;
        private List<String> images;
    }

    @Getter
    @Setter
    public static class EventCreateDto {
        private String seq;
        private String eventName;
        private String startDate;
        private String endDate;
        private String content;
    }

    @Getter
    @Setter
    public static class EventUpdateDto {
        private String seq;
        private String eventName;
        private String startDate;
        private String endDate;
        private String content;
    }

    @Getter
    @Setter
    public static class EventDeleteDto {
        private List<String> seqList;

    }

}