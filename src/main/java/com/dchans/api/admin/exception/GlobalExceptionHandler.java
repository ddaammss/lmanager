package com.dchans.api.admin.exception;

import com.dchans.api.admin.dto.common.PageApiResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<PageApiResponseDto<Object>> handleIllegalArgument(
            IllegalArgumentException e) {
        return ResponseEntity.status(400).body(PageApiResponseDto.error(400, e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<PageApiResponseDto<Object>> handleGeneral(Exception e) {
        return ResponseEntity.status(500).body(PageApiResponseDto.error(500, "Internal Server Error"));
    }
}
