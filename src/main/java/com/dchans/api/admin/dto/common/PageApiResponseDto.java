package com.dchans.api.admin.dto.common;

import java.time.LocalDateTime;
import java.util.List;

// 페이징 전용 API 응답 클래스
public record PageApiResponseDto<T>(
        int code,
        boolean success,
        String message,
        List<T> data,           // 실제 데이터 목록
        int currentPage,        // 페이징 정보들
        int totalPages,
        long totalItems,
        int pageSize,
        LocalDateTime timestamp
) {
    // 페이징 성공 응답
    public static <T> PageApiResponseDto<T> success(
            List<T> data, int currentPage, int totalPages, long totalItems, int pageSize) {
        return new PageApiResponseDto<>(
                200, true, "Success",
                data, currentPage, totalPages, totalItems, pageSize,
                LocalDateTime.now()
        );
    }

    // PageResponse로부터 생성
    public static <T> PageApiResponseDto<T> success(PageResponse<T> pageResponse) {
        return new PageApiResponseDto<>(
                200, true, "Success",
                pageResponse.getData(),
                pageResponse.getCurrentPage(),
                pageResponse.getTotalPages(),
                pageResponse.getTotalItems(),
                pageResponse.getPageSize(),
                LocalDateTime.now()
        );
    }

    // 메시지 포함 성공 응답
    public static <T> PageApiResponseDto<T> success(
            List<T> data, int currentPage, int totalPages, long totalItems, int pageSize, String message) {
        return new PageApiResponseDto<>(
                200, true, message,
                data, currentPage, totalPages, totalItems, pageSize,
                LocalDateTime.now()
        );
    }

    // 에러 응답 (페이징 정보는 비워둠)
    public static <T> PageApiResponseDto<T> error(int code, String message) {
        return new PageApiResponseDto<>(
                code, false, message,
                null, 0, 0, 0, 0,
                LocalDateTime.now()
        );
    }
}