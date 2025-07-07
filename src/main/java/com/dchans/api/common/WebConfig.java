package com.dchans.api.common;

import com.dchans.api.admin.interceptor.AdminInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 관리자 인터셉터 (관리자 페이지만)
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/api/v1/**")
                .excludePathPatterns("/admin/api/v1/login");

        // API 인터셉터 (Flutter 앱 API만)
        /*registry.addInterceptor(apiAuthInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login", "/api/auth/register");*/
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(
                        "http://localhost:3000",     // Vue 개발서버
                        "https://admin.yourdomain.com" // Vue 배포 도메인
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

}
