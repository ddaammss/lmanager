package com.dchans.api.admin.dto.common;

import java.time.LocalDateTime;

public record ApiResponse<T>(
        int code,
        boolean success,
        String message,
        T data,
        LocalDateTime timestamp
) {
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, true, "Success", data, LocalDateTime.now());
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(code, false, message, null, LocalDateTime.now());
    }
}
