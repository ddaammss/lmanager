package com.dchans.api.app.dto.point;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AppPointDto {
    private List<AppPointDto.PointResponseDto> pointResponseDtos;

    @Getter
    @Setter
    public static class PointRequestDto {
        private String seq;
    }

    @Getter
    @Setter
    public static class PointResponseDto {
        private String seq;
        private String storeName;
        private String point;
        private String pointAmount;
        private String reason;
        private String createdAt;
    }
}