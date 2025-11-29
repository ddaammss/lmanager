package com.dchans.api.app.dto.user;

import lombok.*;

@Getter
@Setter
public class AppUserDto {


    @Getter
    @Setter
    public static class UserResponseDto {
        private String seq;
        private String memberName;
        private String profileImage;
    }
}