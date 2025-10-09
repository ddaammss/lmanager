package com.dchans.api.admin.exception;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 비즈니스 예외 (클라이언트 에러)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponseDto<Object>> handleIllegalArgument(
            IllegalArgumentException e) {
        logger.warn("IllegalArgumentException: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponseDto.error(400, e.getMessage()));
    }

    // 커스텀 비즈니스 예외 (추가하면 좋음)
//    @ExceptionHandler(BusinessException.class)
//    public ResponseEntity<ApiResponseDto<Object>> handleBusinessException(
//            BusinessException e) {
//        logger.warn("BusinessException: {}", e.getMessage());
//        return ResponseEntity.status(e.getCode())
//                .body(ApiResponseDto.error(e.getCode(), e.getMessage()));
//    }

    // 일반 예외 (서버 에러) - 보안을 위해 메시지 숨김
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDto<Object>> handleGeneral(Exception e) {
        logger.error("Unexpected Exception: ", e);  // 전체 스택 트레이스 로깅

        // 운영 환경에서는 상세 메시지 숨김
        String message = "서버 오류가 발생했습니다.";

        // 개발 환경에서만 상세 메시지 노출 (선택)
        // if (환경변수.isDevelopment()) {
        //     message = e.getMessage();
        // }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponseDto.error(500, message));
    }
}