package com.dchans.api.app.dto.user;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class AppUserDto {
    @Getter
    @Setter
    public static class UserRequestDto {
        private String seq;
        private String birthTime;
        private String phone;
    }

    @Getter
    @Setter
    public static class UserResponseDto {
        private String seq;
        private String socialId;
        private String memberName;
        private String profileImage;
        private String birthday;
        private String birthYear;
        private String birthTime;
        private String point;
        private String coupon;
        private String gender;
        private String phone;
    }
}