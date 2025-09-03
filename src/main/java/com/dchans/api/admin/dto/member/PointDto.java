package com.dchans.api.admin.dto.member;

import lombok.Getter;
import lombok.Setter;

public record PointDto(
) {
    @Getter
    @Setter
    public static class PointResponseDto {
        private String pointName;
        private String pointUnit;
        private String minUsePoint;
        private String maxHoldPoint;
        private Integer buyPoint;
        private Integer status;
    }

    @Getter
    @Setter
    public static class PointUpdateDto {
        private String pointName;
        private String pointUnit;
        private String minUsePoint;
        private String maxHoldPoint;
        private Integer buyPoint;
        private Integer status;
    }

}