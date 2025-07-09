package com.dchans.api.admin.dto.common;

import java.time.LocalDateTime;

public record ApiResponseDto<T>(
        int code,
        boolean success,
        String message,
        T data,
        LocalDateTime timestamp
) {
    public static <T> ApiResponseDto<T> success(T data) {
        return new ApiResponseDto<>(200, true, "Success", data, LocalDateTime.now());
    }

    public static <T> ApiResponseDto<T> error(int code, String message) {
        return new ApiResponseDto<>(code, false, message, null, LocalDateTime.now());
    }
}
