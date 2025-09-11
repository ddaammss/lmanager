package com.dchans.api.admin.dto.event;

import com.dchans.api.admin.dto.store.StoreDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record EventDto(
) {
    @Getter
    @Setter
    public static class EventRequestDto {
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
    public static class EventResponseDto {
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
    public static class EventCreateDto {
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
        private List<String> images;
    }

    @Getter
    @Setter
    public static class EventUpdateDto {
        private String seq;
        private String answer;
        private String status;
    }

    @Getter
    @Setter
    public static class EventImageDto {
        private String storeCode;
        private String imagePath;
        private String price;
    }
}