package com.dchans.api.admin.interceptor;

import com.dchans.api.admin.dto.common.ApiResponseDto;
import com.dchans.api.common.JwtTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Enumeration;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JwtTokenService jwtTokenService;
    private final ObjectMapper objectMapper;

    public AdminInterceptor(JwtTokenService jwtTokenService, ObjectMapper objectMapper) {
        this.jwtTokenService = jwtTokenService;
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        // CORS 헤더 설정
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // OPTIONS 요청은 인증 없이 통과
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpStatus.OK.value());
            return false;
        }

        // 요청 정보 로깅
        String clientIp = getClientIpAddress(request);
        String userAgent = request.getHeader("User-Agent");
        String requestUri = request.getRequestURI();
        String method = request.getMethod();

        logger.info("API Request - IP: {}, URI: {} {}, User-Agent: {}", clientIp, method, requestUri, userAgent);

        // 헤더 정보
        Enumeration<?> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = (String) headerNames.nextElement();
            String value = request.getHeader(name);

            String token = request.getHeader("Authorization");

            // 토큰에서 사용자 정보 추출
            String jwt = token.substring(7);
            String userId = jwtTokenService.getUsernameFromToken(jwt);
            String role = jwtTokenService.getRoleFromToken(jwt);
            // 요청 컨텍스트에 사용자 정보 저장
            request.setAttribute("userId", userId);
            request.setAttribute("role", role);

            // 토큰 없음
            if (token == null || token.trim().isEmpty()) {
                sendErrorResponse(response, 401, "Authorization 헤더가 필요합니다.");
                return false;
            }
            // Bearer 형식 아님
            if (!token.startsWith("Bearer ")) {
                sendErrorResponse(response, 401, "Bearer 토큰 형식이어야 합니다.");
                return false;
            }
            if (!jwtTokenService.validateToken(token)) {
                sendErrorResponse(response, 401, "인증 토큰이 유효하지 않습니다.");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    private void sendErrorResponse(HttpServletResponse response, int code, String message) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        ApiResponseDto<Void> errorResponse = ApiResponseDto.error(code, message);
        String jsonResponse = objectMapper.writeValueAsString(errorResponse);

        response.getWriter().write(jsonResponse);
    }

    private String getClientIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
