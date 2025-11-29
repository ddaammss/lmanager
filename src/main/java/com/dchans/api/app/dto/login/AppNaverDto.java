package com.dchans.api.app.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AppNaverDto {
    @Data
    public static class NaverLoginRequestDto {
        private String id;
        private String email;
        private String name;
        private String profileImage;
        private String age;
        private String birthday;
        private String birthYear;
        private String gender;
        private String mobile;
    }

    @Data
    public static class NaverLoginResponseDto {
        private String seq;
        private String id;
        private String email;
        private String name;
        private String profileImage;
        private String age;
        private String birthday;
        private String birthYear;
        private String gender;
        private String phone;
        private String jwtToken;

    }
}
