package com.dchans.api.admin.dto.login;

public record LoginDto(
        String name,
        String password,
        String role
) {
    public static class LoginResponseDto {
        private String accessToken;    // JWT 액세스 토큰
        private String refreshToken;   // JWT 리프레시 토큰
        private String username;       // 로그인한 사용자명

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

}
