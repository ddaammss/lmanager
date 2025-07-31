package com.dchans.api.admin.dto.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponseDto {
    private String accessToken;
    private String refreshToken;
    private String username;

    public TokenResponseDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

}
