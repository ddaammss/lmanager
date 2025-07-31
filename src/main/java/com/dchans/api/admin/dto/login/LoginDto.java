package com.dchans.api.admin.dto.login;

import lombok.Getter;
import lombok.Setter;

public record LoginDto(
) {
    @Getter
    @Setter
    public static class LoginRequestDto {
        private String id;
        private String password;
        private String role;

    }

    @Getter
    @Setter
    public static class LoginResponseDto {
        private String id;
        private String password;
        private String role;

    }
}
